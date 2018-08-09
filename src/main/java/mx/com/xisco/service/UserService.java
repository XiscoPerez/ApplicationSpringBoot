package mx.com.xisco.service;

import mx.com.xisco.dto.UserDto;
import mx.com.xisco.persistence.model.User;

public interface UserService {

    User save(UserDto userDto);
}
