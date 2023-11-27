package database.repository;

import annotation.IntegrationTest;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.tinkoff.database.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IntegrationTest
@RequiredArgsConstructor
public class UserRepositoryTest {

    private static final Integer ivanId = 1;
    private final EntityManager entityManager;
    private final UserRepository userRepository;


    @Test
    void findById() {
        var user = userRepository.findById(ivanId);
        assertTrue(user.isPresent());
        user.ifPresent(userRepository::delete);
        entityManager.flush();
        assertTrue(userRepository.findById(ivanId).isEmpty());
    }

    @Test
    void findAll() {
        var users = userRepository.findAll();
        assertFalse(users.isEmpty());
        userRepository.delete(users.get(0));
        entityManager.flush();
        assertTrue(userRepository.findAll().isEmpty());
    }

}
