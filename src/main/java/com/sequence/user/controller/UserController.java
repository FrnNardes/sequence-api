package com.sequence.user.controller;

import com.sequence.user.dto.UserAuthResponse;
import com.sequence.user.dto.UserLoginRequest;
import com.sequence.user.dto.UserRegistrationRequest;
import com.sequence.user.dto.UserResponse;
import com.sequence.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserAuthResponse> register(@RequestBody @Valid UserRegistrationRequest dto){
        UserAuthResponse response = userService.registerUser(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthResponse> login(@RequestBody @Valid UserLoginRequest dto){
        UserAuthResponse response = userService.login(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
