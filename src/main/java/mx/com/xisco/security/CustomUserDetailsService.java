package mx.com.xisco.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mx.com.xisco.persistence.model.Usuario;
import mx.com.xisco.persistence.repository.UsuarioRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String usuario) {
        Optional<Usuario> user = userRepository.findByUsuario(usuario);
        if (user.isPresent()) {
            user.get().getRoles();
            return new CustomUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("No user present with username: " + usuario);
        }
    }

}
