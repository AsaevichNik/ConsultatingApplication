package org.tinkoff.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tinkoff.database.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
