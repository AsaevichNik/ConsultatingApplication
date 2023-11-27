package org.tinkoff.dto.mentor;

import lombok.Value;

@Value
public class MentorReadDto {
    Integer mentorId;
    String experience;
    String howCan_I_Help;
    String skills;
    Integer tagId;
    Integer userId;
}
