package com.sequence.user.service;

import com.sequence.user.dto.UserAuthResponse;
import com.sequence.user.dto.UserLoginRequest;
import com.sequence.user.dto.UserRegistrationRequest;
import com.sequence.user.dto.UserResponse;
import com.sequence.user.mapper.UserMapper;
import com.sequence.user.model.User;
import com.sequence.user.repository.UserRepository;
import com.sequence.user.security.JwtSecurity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurity jwtSecurity;

    @Transactional
    public UserAuthResponse registerUser(UserRegistrationRequest dto){
        String encodedPassword = passwordEncoder.encode(dto.password());

        User user = UserMapper.toEntity(dto, encodedPassword);

        userRepository.save(user);

        String token = jwtSecurity.generateToken(user.getEmail());

        return UserMapper.toAuthResponse(UserMapper.toResponse(user), token);
    }

    @Transactional
    public UserAuthResponse login(UserLoginRequest dto){
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        String rawPassword = dto.password();

        if(!passwordEncoder.matches(rawPassword, user.getPassword())){
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtSecurity.generateToken(user.getEmail());

        return UserMapper.toAuthResponse(UserMapper.toResponse(user), token);
    }
}
