package com.leodev.springmongo.resource;

import com.leodev.springmongo.domain.User;
import com.leodev.springmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
//        User m = new User("1", "Maria", "maria@gmail.com");
//        User a = new User("2", "Alex", "alex@gmail.com");
        List<User> list = userService.findAll();
//        list.addAll(Arrays.asList(m, a));
        return ResponseEntity.ok().body(list);
    }
}
