package services;

import annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.tinkoff.dto.user.UserReadDto;
import org.tinkoff.services.UserService;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@IntegrationTest
@RequiredArgsConstructor
public class UserServiceTest {

    private final UserService userService;

    public static final Integer IVAN_ID = 8;

    @Test
    public void findByIdTest() {
        Optional<UserReadDto> ivan = userService.findById(IVAN_ID);
        assertThat(ivan).isNotNull();
        ivan.ifPresent(user -> System.out.println(user.getBirthday()));
    }

    @Test
    public void findByUsernameTest(){
        Optional<UserReadDto> ivan = userService.findByUsername("Романовский Иван Михайлович");
        assertThat(ivan).isNotNull();
    }

    @Test
    public void findAllTest() {
        List<UserReadDto> users = userService.findAll();
        assertThat(users).hasSize(5);
    }

}
