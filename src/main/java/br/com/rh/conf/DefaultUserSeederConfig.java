package br.com.rh.conf;

import br.com.rh.entity.User;
import br.com.rh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Configuration
public class DefaultUserSeederConfig {

    @Autowired
    private UserRepository repository;

    @Value(value = "${app.default.username}")
    private String defaultUsername;

    @Value(value = "${app.default.password}")
    private String defaultPassword;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    public void seedUsersTable() {
        Optional<User> user = repository.findByUsername(defaultUsername);

        if(!user.isPresent()){
            repository.save(new User(defaultUsername, bCryptPasswordEncoder().encode(defaultPassword)));
            return;
        }

        user.get().setPassword(bCryptPasswordEncoder().encode(defaultPassword));
        repository.save(user.get());
    }
}
