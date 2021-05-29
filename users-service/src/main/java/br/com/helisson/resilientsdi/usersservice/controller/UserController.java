package br.com.helisson.resilientsdi.usersservice.controller;

import br.com.helisson.resilientsdi.usersservice.domain.User;
import br.com.helisson.resilientsdi.usersservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    JpaRepository<User, String> getRepository() {
        return userRepository;
    }
}
