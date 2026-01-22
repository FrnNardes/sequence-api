package com.sequence.pathway.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "sequences")
public class Sequence {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pathway_id", nullable = false)
    private Pathway pathway;

    @Column(name = "sequence_number", nullable = false)
    private int sequenceNumber;
    
    @Column(nullable = false)
    private String title;

    @Column(name = "xp_required", nullable = false)
    private int xpRequired;
    
    @Column(name = "ritual_description")
    private String ritualDescription;
    
    @Builder
    public Sequence(Pathway pathway, int sequenceNumber, String title, int xpRequired, String ritualDescription){
        this.id = UUID.randomUUID();
        this.pathway = pathway;
        this.sequenceNumber = sequenceNumber;
        this.title = title;
        this.xpRequired = xpRequired;
        this.ritualDescription = ritualDescription;
    }

}
