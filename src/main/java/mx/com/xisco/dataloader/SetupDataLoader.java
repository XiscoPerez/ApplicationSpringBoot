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

import mx.com.xisco.persistence.model.Privilegio;
import mx.com.xisco.persistence.model.Rol;
import mx.com.xisco.persistence.model.Usuario;
import mx.com.xisco.persistence.repository.PrivilegioRepository;
import mx.com.xisco.persistence.repository.RolRepository;
import mx.com.xisco.persistence.repository.UsuarioRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PrivilegioRepository privilegioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

//        // == create initial privileges
//        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
//        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
//        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");
//
//        // == create initial roles
//        final List<Privilege> adminPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
//        final List<Privilege> userPrivileges = new ArrayList<>(Arrays.asList(readPrivilege, passwordPrivilege));
//        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
//        createRoleIfNotFound("ROLE_USER", userPrivileges);
//
//        // == create initial user
//        createUserIfNotFound("testuser", "Test", "Test", "test", new ArrayList<>(Arrays.asList(adminRole)));

        alreadySetup = true;
    }

    @Transactional
    public final Privilegio createPrivilegeIfNotFound(final String nombre) {
        Optional<Privilegio> optPrivilegio = privilegioRepository.findByNombre(nombre);
        Privilegio privilegio = optPrivilegio.orElse(new Privilegio());
        if (!optPrivilegio.isPresent()) {
        	privilegio.setNombre(nombre);
        	privilegio = privilegioRepository.save(privilegio);
        }
        return privilegio;
    }

    @Transactional
    public final Rol createRoleIfNotFound(final String nombre, final Collection<Privilegio> privilegios) {
        Optional<Rol> optRole = rolRepository.findByNombre(nombre);
        Rol role = optRole.orElse(new Rol());
        if (!optRole.isPresent()) {
            role.setNombre(nombre);
            role.setPrivilegios(privilegios);
            role = rolRepository.save(role);
        }

        return role;
    }

    @Transactional
    public final Usuario createUserIfNotFound(final String usuario, final String nombre, final String apellidoPaterno, final String contrasenia, final Collection<Rol> roles) {
        Optional<Usuario> optUsuario = usuarioRepository.findByUsuario(usuario);
        Usuario usuarioNuevo = optUsuario.orElse(new Usuario());
        if (!optUsuario.isPresent()) {
        	usuarioNuevo.setUsuario(usuario);
        	usuarioNuevo.setNombre(nombre);
        	usuarioNuevo.setApellidoPatarno(apellidoPaterno);
        	usuarioNuevo.setContrasenia(passwordEncoder.encode(contrasenia));
        	usuarioNuevo.setRoles(roles);
        	usuarioNuevo = usuarioRepository.save(usuarioNuevo);
        }
        return usuarioNuevo;
    }

}