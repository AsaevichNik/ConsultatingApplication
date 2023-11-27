package database.repository;

import annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.tinkoff.database.entity.Mentor;
import org.tinkoff.database.repository.MentorRepository;

import java.util.Optional;

@IntegrationTest
@RequiredArgsConstructor
public class MentorRepositoryTest {
    private final MentorRepository mentorRepository;

    private static final Integer IVAN_ID = 8;

    @Test
    void findById() {
       Optional<Mentor> ivan = mentorRepository.findById(IVAN_ID);
       ivan.ifPresent(user -> System.out.println(user.getMentorId()));
    }

}
