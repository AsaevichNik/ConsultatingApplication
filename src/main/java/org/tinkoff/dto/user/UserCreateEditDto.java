package org.tinkoff.dto.user;

import lombok.Value;
import org.tinkoff.database.entity.Role;

@Value
public class UserCreateEditDto {

     Integer birthday;

     String email;

     String fullName;

     String password;

     Role role;
}
