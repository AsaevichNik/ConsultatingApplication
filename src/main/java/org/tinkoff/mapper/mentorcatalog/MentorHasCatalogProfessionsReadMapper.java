package org.tinkoff.mapper.mentorcatalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.MentorHasCatalogProfessions;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.dto.mentor.MentorReadDto;
import org.tinkoff.dto.mentorcatalog.MentorHasCatalogProfessionsReadDto;
import org.tinkoff.mapper.Mapper;
import org.tinkoff.mapper.catalog.CatalogProfessionsReadMapper;
import org.tinkoff.mapper.mentor.MentorReadMapper;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MentorHasCatalogProfessionsReadMapper implements
        Mapper<MentorHasCatalogProfessions, MentorHasCatalogProfessionsReadDto> {

    private final MentorReadMapper mentorReadMapper;
    private final CatalogProfessionsReadMapper catalogProfessionsReadMapper;

    @Override
    public MentorHasCatalogProfessionsReadDto map(MentorHasCatalogProfessions object) {

        MentorReadDto mentorReadDto = Optional
                .ofNullable(object.getMentor())
                .map(mentorReadMapper::map)
                .orElse(null);

        CatalogProfessionsReadDto catalogProfessionsReadDto = Optional
                        .ofNullable(object.getCatalogProfessions())
                        .map(catalogProfessionsReadMapper::map)
                        .orElse(null);

        return new MentorHasCatalogProfessionsReadDto(
                catalogProfessionsReadDto, mentorReadDto
        );
    }
}
