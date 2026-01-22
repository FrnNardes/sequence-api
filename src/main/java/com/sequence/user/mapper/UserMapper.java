package com.sequence.user.mapper;

import com.sequence.user.dto.UserAuthResponse;
import com.sequence.user.dto.UserRegistrationRequest;
import com.sequence.user.dto.UserResponse;
import com.sequence.user.model.User;

public class UserMapper {
    public static UserResponse toResponse(User user){
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getCreatedAt()
        );
    }

    public static UserAuthResponse toAuthResponse(UserResponse userResponse, String token){
        return new UserAuthResponse(
                userResponse,
                token
        );
    }
    public static User toEntity(UserRegistrationRequest dto, String encodedPassword){
        return User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(encodedPassword)
                .build();
    }
}
