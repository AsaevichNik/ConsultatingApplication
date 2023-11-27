package org.tinkoff.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinkoff.database.repository.MentorRepository;
import org.tinkoff.dto.mentor.MentorCreateEditDto;
import org.tinkoff.dto.mentor.MentorReadDto;
import org.tinkoff.mapper.mentor.MentorCreateEditMapper;
import org.tinkoff.mapper.mentor.MentorReadMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorService {

    private final MentorRepository mentorRepository;
    private final MentorCreateEditMapper mentorCreateEditMapper;
    private final MentorReadMapper mentorReadMapper;

    public Optional<MentorReadDto> findById(Integer id) {
        return mentorRepository
                .findById(id)
                .map(mentorReadMapper::map);
    }

    public List<MentorReadDto> findAll() {
        return mentorRepository
                .findAll()
                .stream()
                .map(mentorReadMapper::map)
                .toList();
    }

    @Transactional
    public MentorReadDto create(MentorCreateEditDto dto) {
        return Optional.of(dto)
                .map(mentorCreateEditMapper::map)
                .map(mentorRepository::save)
                .map(mentorReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<MentorReadDto> update(Integer id, MentorCreateEditDto dto) {
        return mentorRepository
                .findById(id)
                .map(mentor -> mentorCreateEditMapper.map(dto, mentor))
                .map(mentorRepository::saveAndFlush)
                .map(mentorReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return mentorRepository.findById(id)
                .map(mentor -> {
                    mentorRepository.delete(mentor);
                    mentorRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
