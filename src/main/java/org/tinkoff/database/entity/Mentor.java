package org.tinkoff.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mentor")
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorId;

    @Column(nullable = false)
    private String experience;

    @Column(nullable = false)
    private String howCan_I_Help;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private Integer tagId;

    @Column(nullable = false)
    private Integer userId;

    @Builder.Default
    @OneToMany(mappedBy = "mentor")
    private List<MentorHasCatalogProfessions> mentorHasCatalogProfessions = new ArrayList<>();

}
