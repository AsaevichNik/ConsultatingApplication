package org.tinkoff.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MentorHasCatalogProfessionsId implements Serializable {

    @Column(name = "mentor_mentor_id")
    private Integer mentorMentorId;

    @Column(name = "catalog_professions_id")
    private Integer catalogProfessionsId;
}