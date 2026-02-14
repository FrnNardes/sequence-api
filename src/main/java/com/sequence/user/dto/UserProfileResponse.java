package com.sequence.user.dto;

import java.util.UUID;

public record UserProfileResponse(
        String username,
        String email,
        String pathway, // "The Lifter"
        int level,      // Calculated from XP
        int currentXp,
        int xpToNextLevel,
        int totalWorkouts // Optional, or fetch separately
) {
}
