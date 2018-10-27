package br.com.rh.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;

public class LoginResponseDto {

    @JsonInclude(value=JsonInclude.Include.NON_EMPTY)
    private String token;

    @JsonInclude(value=JsonInclude.Include.NON_EMPTY)
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
