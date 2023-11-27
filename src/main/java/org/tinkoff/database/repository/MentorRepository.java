package org.tinkoff.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tinkoff.database.entity.Mentor;


@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

}
