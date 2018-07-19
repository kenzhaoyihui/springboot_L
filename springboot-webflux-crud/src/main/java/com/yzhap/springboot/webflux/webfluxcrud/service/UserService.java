package com.yzhap.springboot.webflux.webfluxcrud.service;

import com.yzhap.springboot.webflux.webfluxcrud.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    //private final Map<String, User> data = new ConcurrentHashMap<>();
    Map<String, User> data = new ConcurrentHashMap<>();

    public Flux<User> list() {
        return Flux.fromIterable(this.data.values());
    }

    public Flux<User> getById(Flux<String> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    public Mono<User> getById(String id) {
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new Exception()));
    }

    public Mono<User> createOrUpdate(User user) {
        this.data.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> delete(String id) {
        return Mono.justOrEmpty(this.data.remove(id));
    }
}
