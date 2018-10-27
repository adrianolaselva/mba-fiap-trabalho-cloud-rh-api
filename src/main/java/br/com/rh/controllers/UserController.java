package br.com.rh.controllers;

import br.com.rh.entity.User;
import br.com.rh.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable("id") String id){

        Optional<User> user = this.repository.findById(id);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user.get());
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody  User user, BindingResult result){

        log.info("Request parameters: {} " + user.toString());

        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        this.repository.save(user);

        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity save(@PathVariable("id") String id, @Valid @RequestBody  User user, BindingResult result){

        if(!this.repository.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        log.info("Request parameters: {} " + user.toString());

        if(result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        user.setId(id);

        this.repository.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){

        if(!this.repository.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        this.repository.deleteById(id);

        return ResponseEntity.ok(null);
    }

    @GetMapping()
    public ResponseEntity<Page<User>> findAll(
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "sort", defaultValue = "id", required = false) String ord,
            @RequestParam(value = "dir", defaultValue = "ASC", required = false) String dir) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(dir), ord);

        Page<User> users = this.repository.findAll(pageRequest);

        return ResponseEntity.ok(users);
    }
}
