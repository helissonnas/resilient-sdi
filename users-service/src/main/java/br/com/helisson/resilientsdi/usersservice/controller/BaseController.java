package br.com.helisson.resilientsdi.usersservice.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T> {

    abstract JpaRepository<T, String> getRepository();

    @GetMapping
    public @ResponseBody
    ResponseEntity findAll() {
        try {
            return new ResponseEntity(getRepository().findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity findOne(@PathVariable String id) {
        try {
            return new ResponseEntity(getRepository().findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public @ResponseBody
    ResponseEntity create(@RequestBody T object) {
        try {
            return new ResponseEntity(getRepository().save(object), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public @ResponseBody
    ResponseEntity update(@RequestBody T object) {
        try {
            return new ResponseEntity(getRepository().save(object), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity delete(@RequestBody T object) {
        try {
            return new ResponseEntity(getRepository().save(object), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
