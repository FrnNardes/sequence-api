package com.sequence.pathway.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "pathways")
public class Pathway {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "pathway", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sequence> sequences;

    @Builder
    public Pathway(String name, String description){
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
    }
}
