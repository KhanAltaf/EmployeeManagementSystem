package com.assessment.controller;

import com.assessment.dto.request.UserForm;
import com.assessment.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    @ApiOperation(value = "Create new User")
    public ResponseEntity<?> saveUser(@RequestBody UserForm userForm){
        return userService.saveUser(userForm);
    }
}
