package mx.com.xisco.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mx.com.xisco.dto.UserDto;
import mx.com.xisco.persistence.model.Role;
import mx.com.xisco.persistence.model.User;
import mx.com.xisco.persistence.repository.RoleRepository;
import mx.com.xisco.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User save(final UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> optRole = roleRepository.findByName("ROLE_USER");
        if (optRole.isPresent()) {
            Collection<Role> roles = new ArrayList<>();
            roles.add(optRole.get());
            user.setRoles(roles);
        }
        return userRepository.save(user);
    }

}
