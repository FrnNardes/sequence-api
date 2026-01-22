package com.sequence.user.controller;

import com.sequence.user.dto.*;
import com.sequence.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/pathway")
    public ResponseEntity<UserResponse> selectPathway(@RequestBody PathwaySelectionRequest dto, Authentication auth) {
        String email = (String) auth.getPrincipal();
        UserResponse response = userService.selectPathway(email, dto);
        return ResponseEntity.ok(response);
    }
}
