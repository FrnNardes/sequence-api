package com.sequence.pathway.repository;

import com.sequence.pathway.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface SequenceRepository extends JpaRepository<Sequence, UUID> {
    Optional<Sequence> findByPathwayIdAndSequenceNumber(UUID pathwayId, int sequenceNumber);
}
