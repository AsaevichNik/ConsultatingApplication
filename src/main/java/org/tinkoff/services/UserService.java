package org.tinkoff.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinkoff.database.repository.UserRepository;
import org.tinkoff.dto.user.UserCreateEditDto;
import org.tinkoff.dto.user.UserReadDto;
import org.tinkoff.mapper.user.UserCreateEditMapper;
import org.tinkoff.mapper.user.UserReadMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public Optional<UserReadDto> findById(Integer id) {
        return userRepository
                .findById(id)
                .map(userReadMapper::map);
    }

    public List<UserReadDto> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Integer id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(user -> userCreateEditMapper.map(userDto, user))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }


}
