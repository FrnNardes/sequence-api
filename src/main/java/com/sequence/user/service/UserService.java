package com.sequence.user.service;

import com.sequence.pathway.model.Pathway;
import com.sequence.pathway.model.Sequence;
import com.sequence.pathway.repository.PathwayRepository;
import com.sequence.pathway.repository.SequenceRepository;
import com.sequence.user.dto.*;
import com.sequence.user.mapper.UserMapper;
import com.sequence.user.model.User;
import com.sequence.user.repository.UserRepository;
import com.sequence.user.security.JwtSecurity;
import com.sequence.workout.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PathwayRepository pathwayRepository;
    private final SequenceRepository sequenceRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSecurity jwtSecurity;
    private final WorkoutRepository workoutRepository;

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

    @Transactional
    public UserResponse selectPathway(String email, PathwaySelectionRequest dto) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getPathway() != null) {
            throw new RuntimeException("User has already chosen a pathway!");
        }

        Pathway pathway = pathwayRepository.findByName(dto.pathwayName())
                .orElseThrow(() -> new RuntimeException("Pathway not found: " + dto.pathwayName()));

        Sequence startSequence = sequenceRepository.findByPathwayIdAndSequenceNumber(pathway.getId(), 9)
                .orElseThrow(() -> new RuntimeException("Sequence 9 not found for pathway: " + pathway.getName()));

        user.choosePathway(pathway, startSequence);
        userRepository.save(user);

        return UserMapper.toResponse(user);
    }

    @Transactional
    public UserProfileResponse getProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        int totalWorkouts = workoutRepository.countAllByUser(user);

        return new UserProfileResponse(
                user.getUsername(),
                user.getEmail(),
                user.getPathway().getName(),
                user.getLevel(),
                user.getXp(),
                (1000 - user.getXp()),
                totalWorkouts
        );
    }
}
