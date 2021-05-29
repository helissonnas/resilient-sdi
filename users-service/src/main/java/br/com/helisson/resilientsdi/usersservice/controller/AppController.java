package br.com.helisson.resilientsdi.usersservice.controller;

import br.com.helisson.resilientsdi.usersservice.domain.App;
import br.com.helisson.resilientsdi.usersservice.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController extends BaseController<App> {

    @Autowired
    private AppRepository appRepository;


    @Override
    JpaRepository<App, String> getRepository() {
        return appRepository;
    }
}
