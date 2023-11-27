package org.tinkoff.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mentor_has_catalog_professions")

public class MentorHasCatalogProfessions implements Serializable {

    @EmbeddedId
    private MentorHasCatalogProfessionsId mentorHasCatalogProfessionsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("catalogProfessionsId")
    @JoinColumn(name = "catalog_professions_id")
    private CatalogProfessions catalogProfessions;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mentorMentorId")
    @JoinColumn(name = "mentor_mentor_id")
    private Mentor mentor;

    public void setCatalogProfessions(CatalogProfessions catalogProfessions) {
        this.catalogProfessions = catalogProfessions;
        this.catalogProfessions.getMentorHasCatalogProfessions().add(this);
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
        this.mentor.getMentorHasCatalogProfessions().add(this);
    }
}
