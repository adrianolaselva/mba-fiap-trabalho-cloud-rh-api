package br.com.rh.dto.auth;

import javax.validation.constraints.NotNull;

public class LoginRequestDto {

    @NotNull(message = "username é obrigatório")
    private String username;

    @NotNull(message = "password é obrigatório")
    private String password;

    public LoginRequestDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
