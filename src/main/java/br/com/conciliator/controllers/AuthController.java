package br.com.conciliator.controllers;

import br.com.conciliator.constants.SecurityConstants;
import br.com.conciliator.dto.auth.LoginRequestDto;
import br.com.conciliator.dto.auth.LoginResponseDto;
import br.com.conciliator.entity.User;
import br.com.conciliator.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto login, BindingResult result){

        LoginResponseDto response = new LoginResponseDto();

        log.info("Request parameters: {} " + login.toString());

        Optional<User> user = this.repository.findByUsername(login.getUsername());

        if(!user.isPresent()){
            response.setMessage("username inválido");
            return ResponseEntity.badRequest().body(response);
        }

        if(!BCrypt.checkpw(login.getPassword(), user.get().getPassword())){
            response.setMessage("password inválido");
            return ResponseEntity.badRequest().body(response);
        }

        String token = JWT.create()
                .withSubject(user.get().getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

        response.setMessage("autenticado com sucesso");
        response.setToken(SecurityConstants.TOKEN_PREFIX + token);

        return ResponseEntity.ok(response);
    }

}
