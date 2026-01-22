package com.sequence.pathway.repository;

import com.sequence.pathway.model.Pathway;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface PathwayRepository extends JpaRepository<Pathway, UUID> {
    Optional<Pathway> findByName(String name);
}
