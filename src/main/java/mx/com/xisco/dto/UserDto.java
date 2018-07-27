package mx.com.xisco.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
    @NotNull
    @Size(min = 6, max = 45)
    private String username;

    @NotNull
    @Size(min = 8, max = 60)
    private String password;

    private String confirmPassword;

    @NotNull
    @Size(min = 6, max = 45)
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(final String matchingPassword) {
        confirmPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}
