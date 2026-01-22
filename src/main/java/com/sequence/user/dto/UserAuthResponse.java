package com.sequence.user.dto;

public record UserAuthResponse (
        UserResponse userResponse,
        String token
){}
