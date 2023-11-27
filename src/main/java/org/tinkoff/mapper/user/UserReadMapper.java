package org.tinkoff.mapper.user;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.User;
import org.tinkoff.dto.user.UserReadDto;
import org.tinkoff.mapper.Mapper;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                                object.getId(),
                                object.getBirthday(),
                                object.getEmail(),
                                object.getFullName(),
                                object.getRole()
        );
    }
}
