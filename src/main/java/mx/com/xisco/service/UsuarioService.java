package mx.com.xisco.service;

import mx.com.xisco.dto.UserDto;
import mx.com.xisco.persistence.model.Usuario;

public interface UsuarioService {

    Usuario save(UserDto userDto);
}
