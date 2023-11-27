package services;

import annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.tinkoff.dto.tag.TagCreateEditDto;
import org.tinkoff.dto.tag.TagReadDto;
import org.tinkoff.services.TagService;
import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
@RequiredArgsConstructor
public class TagServiceTest {

    private final TagService tagService;

    @Test
    public void test() {
        TagReadDto tagReadDto = tagService.create(new TagCreateEditDto("c++"));
        assertThat(tagReadDto).isNotNull();

    }
}
