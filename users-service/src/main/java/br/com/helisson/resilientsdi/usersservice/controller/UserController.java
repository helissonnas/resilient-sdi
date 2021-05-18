package br.com.helisson.resilientsdi.usersservice.controller;

import br.com.helisson.resilientsdi.usersservice.domain.User;
import br.com.helisson.resilientsdi.usersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity findOne(@PathVariable String id) {
        try {
            return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity create(@RequestBody User user) {
        try {
            return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public @ResponseBody
    ResponseEntity update(@RequestBody User user) {
        try {
            return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity delete(@RequestBody User user) {
        try {
            return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
