package com.sarpio.userservice.controller;

import com.sarpio.userservice.controller.dto.ResponseTemplateDTO;
import com.sarpio.userservice.entity.Users;
import com.sarpio.userservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user) {
        return usersService.saveUser(user);
    }

//    @GetMapping("/{id}")
//    public Users findUserById(@PathVariable("id") Long userId) {
//        return usersService.findUserById(userId);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateDTO findUserWithDepartment(@PathVariable("id") Long userId) {
    return usersService.findUserWithDepartment(userId);
    }
}
