package com.yzhap.springboot.webflux.webfluxcrud.controller;

import com.yzhap.springboot.webflux.webfluxcrud.domain.User;
import com.yzhap.springboot.webflux.webfluxcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    //private final UserService userService;
    @Autowired
    UserService userService;

//    @Autowired
//    public UserController(final UserService userService) {
//        this.userService = userService;
//    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    @ExceptionHandler(Exception.class)
    public void notFound() {
    }

    @GetMapping("")
    public Flux<User> list() {
        return this.userService.list();
    }

    @GetMapping(value = "/{id}")
    public Mono<User> getById(@PathVariable("id") String id) {
        return this.userService.getById(id);
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody User user) {
        return this.userService.createOrUpdate(user);
    }

    @PutMapping(value = "/{id}")
    public Mono<User> update(@PathVariable("id") String id, @RequestBody User user) {
        Objects.requireNonNull(user);
        user.setId(id);
        return this.userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Mono<User> delete(@PathVariable("id") String id) {
        return this.userService.delete(id);
    }
}