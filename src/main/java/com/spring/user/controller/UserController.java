package com.spring.user.controller;

import com.spring.user.dto.HttpResponse;
import com.spring.user.dto.RegisterUserRequest;
import com.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public HttpResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.registerUser(request);
        return HttpResponse.<String>builder().result("OK").build();
    }
}