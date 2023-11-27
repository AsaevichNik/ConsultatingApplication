package controllers;

import annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.tinkoff.controllers.UserController;
import static org.assertj.core.api.Assertions.assertThat;


@IntegrationTest
@ContextConfiguration
@RequiredArgsConstructor
class UserControllerTest {
    private final UserController userController;

    @Test
    void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }
}
