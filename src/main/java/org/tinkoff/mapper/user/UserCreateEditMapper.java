package org.tinkoff.mapper.user;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.User;
import org.tinkoff.dto.user.UserCreateEditDto;
import org.tinkoff.mapper.Mapper;


@Component
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);
        return user;
    }

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    public void copy(UserCreateEditDto object, User user) {
        user.setFullName(object.getFullName());
        user.setRole(object.getRole());
        user.setBirthday(object.getBirthday());
        user.setPassword(object.getPassword());
        user.setEmail(object.getEmail());
    }
}
