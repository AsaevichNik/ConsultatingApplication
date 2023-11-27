package org.tinkoff.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tinkoff.database.entity.CatalogProfessions;

import java.util.Optional;

@Repository
public interface CatalogProfessionsRepository extends
        JpaRepository<CatalogProfessions, Integer> {
    Optional<CatalogProfessions> findByName(String name);
}
