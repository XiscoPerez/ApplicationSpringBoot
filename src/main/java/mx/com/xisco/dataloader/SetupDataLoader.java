package mx.com.xisco.dataloader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.com.xisco.persistence.model.Privilege;
import mx.com.xisco.persistence.model.Role;
import mx.com.xisco.persistence.model.User;
import mx.com.xisco.persistence.repository.PrivilegeRepository;
import mx.com.xisco.persistence.repository.RoleRepository;
import mx.com.xisco.persistence.repository.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
        final List<Privilege> userPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, passwordPrivilege));
        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", userPrivileges);

        // == create initial user
        createUserIfNotFound("testuser", "Test", "Test", "test", new ArrayList<>(Arrays.asList(adminRole)));

        alreadySetup = true;
    }

    @Transactional
    public final Privilege createPrivilegeIfNotFound(final String name) {
        Optional<Privilege> optPrivilege = privilegeRepository.findByName(name);
        Privilege privilege = optPrivilege.orElse(new Privilege());
        if (!optPrivilege.isPresent()) {
            privilege.setName(name);
            privilege = privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    public final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Optional<Role> optRole = roleRepository.findByName(name);
        Role role = optRole.orElse(new Role());
        if (!optRole.isPresent()) {
            role.setName(name);
            role.setPrivileges(privileges);
            role = roleRepository.save(role);
        }

        return role;
    }

    @Transactional
    public final User createUserIfNotFound(final String username, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        Optional<User> optUser = userRepository.findByUsername(username);
        User user = optUser.orElse(new User());
        if (!optUser.isPresent()) {
            user.setUsername(username);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles(roles);
            user = userRepository.save(user);
        }
        return user;
    }

}