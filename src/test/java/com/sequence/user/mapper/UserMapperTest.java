package com.sequence.user.mapper;

import com.sequence.user.dto.UserRegistrationRequest;
import com.sequence.user.dto.UserResponse;
import com.sequence.user.model.User;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private static final UUID ID = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static final OffsetDateTime CREATED_AT = OffsetDateTime.parse("2024-01-01T10:00:00Z");
    private static final String ENCODED_PASSWORD = "encodedPassword";
    @Test
    void givenUser_whenToResponse_thenReturnUserResponse(){
        // Arrange: Create a User entity using the @Builder
        User user = User.builder()
                .username("testUser")
                .id(ID)
                .email("testUser@gmail.com")
                .password("password123")
                .createdAt(CREATED_AT)
                .build();

        // Act: Call UserMapper.toResponse
        UserResponse response = UserMapper.toResponse(user);
        
        // Assert: Use assertEquals(expected, actual) to verify fields
        assertEquals(ID, response.id());
        assertEquals("testUser@gmail.com", response.email());
        assertEquals("testUser", response.username());
        assertEquals(CREATED_AT, response.createdAt());
    }

    @Test
    void givenUserRequest_whenMappingToEntity_thenReturnUser(){
        // Arrange: Create a UserRequest
        UserRegistrationRequest request = new UserRegistrationRequest(
                "testUser",
                "testUser@gmail.com",
                "password123"
        );
        // Act
        User user = UserMapper.toEntity(request, ENCODED_PASSWORD);

        // Assert
        assertNotNull(user.getId());
        assertEquals("testUser", user.getUsername());
        assertEquals("testUser@gmail.com", user.getEmail());
        assertEquals(ENCODED_PASSWORD, user.getPassword());
        assertNotNull(user.getCreatedAt());
    }
}