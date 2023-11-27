package org.tinkoff.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinkoff.database.entity.MentorHasCatalogProfessionsId;
import org.tinkoff.database.repository.MentorHasCatalogProfessionsRepository;
import org.tinkoff.dto.mentorcatalog.MentorHasCatalogProfessionsCreateEditDto;
import org.tinkoff.dto.mentorcatalog.MentorHasCatalogProfessionsReadDto;
import org.tinkoff.mapper.mentorcatalog.MentorHasCatalogProfessionsCreateEditMapper;
import org.tinkoff.mapper.mentorcatalog.MentorHasCatalogProfessionsReadMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MentorHasCatalogProfessionsService {

    private final MentorHasCatalogProfessionsRepository mentorHasCatalogProfessionsRepository;
    private final MentorHasCatalogProfessionsCreateEditMapper mentorHasCatalogProfessionsCreateEditMapper;
    private final MentorHasCatalogProfessionsReadMapper mentorHasCatalogProfessionsReadMapper;

    public List<MentorHasCatalogProfessionsReadDto> findAll() {
        return mentorHasCatalogProfessionsRepository
                .findAll()
                .stream()
                .map(mentorHasCatalogProfessionsReadMapper::map)
                .toList();
    }

    public Optional<MentorHasCatalogProfessionsReadDto> findById(MentorHasCatalogProfessionsId id) {
        return mentorHasCatalogProfessionsRepository
                .findById(id)
                .map(mentorHasCatalogProfessionsReadMapper::map);
    }

    @Transactional
    public MentorHasCatalogProfessionsReadDto create(MentorHasCatalogProfessionsCreateEditDto dto) {
        return Optional.of(dto)
                .map(mentorHasCatalogProfessionsCreateEditMapper::map)
                .map(mentorHasCatalogProfessionsRepository::save)
                .map(mentorHasCatalogProfessionsReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public boolean delete(MentorHasCatalogProfessionsId id) {
        return mentorHasCatalogProfessionsRepository.findById(id)
                .map(mentor -> {
                    mentorHasCatalogProfessionsRepository.delete(mentor);
                    mentorHasCatalogProfessionsRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
