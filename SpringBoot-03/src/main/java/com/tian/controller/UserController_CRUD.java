package com.tian.controller;

import com.tian.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController_CRUD {
    Map<Object, User> map = new HashMap<>();
    @PostConstruct
    //依赖关系注入完成之后，执行初始化
    public void init(){
         map.put(1,new User(1,"田智龙",22));
         map.put(2,new User(2,"德军",24));
         map.put(3,new User(3,"日军",26));
    }

    //获取所有用户
    @GetMapping("/getUser")
    public Flux<User> getAll() {
        return Flux.fromIterable(map.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList()));
    }


    /**
     * 获取单个用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return Mono.justOrEmpty(map.get(id));
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @PostMapping("")
    public Mono<ResponseEntity<String>> addUser(User user) {
        map.put(user.getId(), user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }

    /**
     * 修改用户
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> putUser(@PathVariable int id, User user) {
        user.setId(id);
        map.put(id, user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id) {
        map.remove(id);
        return Mono.just(new ResponseEntity<>("删除成功", HttpStatus.ACCEPTED));
    }



}
