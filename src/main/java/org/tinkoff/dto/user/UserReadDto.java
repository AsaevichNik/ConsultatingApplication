package org.tinkoff.dto.user;

import lombok.Value;
import org.tinkoff.database.entity.Role;

@Value
public class UserReadDto {

    Integer id;

    Integer birthday;

    String email;

    String fullName;

    Role role;
}
