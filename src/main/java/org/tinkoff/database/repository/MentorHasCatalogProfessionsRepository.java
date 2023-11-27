package org.tinkoff.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tinkoff.database.entity.MentorHasCatalogProfessions;
import org.tinkoff.database.entity.MentorHasCatalogProfessionsId;

@Repository
public interface MentorHasCatalogProfessionsRepository extends
        JpaRepository<MentorHasCatalogProfessions, MentorHasCatalogProfessionsId> {

}
