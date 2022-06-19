package com.example.appwarehouse.controller;

import com.example.appwarehouse.Entity.User;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.payload.UsersDto;
import com.example.appwarehouse.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;


    @PostMapping("/save")
    public Result saveUsers(@RequestBody UsersDto usersDto){
        Result result = usersService.saveUsersService(usersDto);
        return result;
    }

    @GetMapping
    public List<User> getUser(){
        List<User> userService = usersService.getUserService();
        return userService;
    }

    @GetMapping("/{id}")
    public User getByIdUser(@PathVariable Integer id){
        User byIdUserService = usersService.getByIdUserService(id);
        return byIdUserService;
    }

    @DeleteMapping("/{id}")
    public Result deleteByIdUser(@PathVariable Integer id){
        Result result = usersService.deleteByIdUserService(id);
        return result;
    }

    @PutMapping("/{id}")
    public Result updateUserById(@PathVariable Integer id, @RequestBody UsersDto usersDto){
        Result result = usersService.updateUserByIdService(id,usersDto);
        return result;
    }
}
