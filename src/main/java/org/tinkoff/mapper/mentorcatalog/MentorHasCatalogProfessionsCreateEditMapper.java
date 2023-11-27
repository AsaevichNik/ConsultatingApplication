package org.tinkoff.mapper.mentorcatalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.CatalogProfessions;
import org.tinkoff.database.entity.Mentor;
import org.tinkoff.database.entity.MentorHasCatalogProfessions;
import org.tinkoff.database.entity.MentorHasCatalogProfessionsId;
import org.tinkoff.database.repository.CatalogProfessionsRepository;
import org.tinkoff.database.repository.MentorRepository;
import org.tinkoff.dto.mentorcatalog.MentorHasCatalogProfessionsCreateEditDto;
import org.tinkoff.mapper.Mapper;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MentorHasCatalogProfessionsCreateEditMapper implements
        Mapper<MentorHasCatalogProfessionsCreateEditDto, MentorHasCatalogProfessions> {

    private final MentorRepository mentorRepository;
    private final CatalogProfessionsRepository catalogProfessionsRepository;

    public MentorHasCatalogProfessions map(MentorHasCatalogProfessionsCreateEditDto object) {
        MentorHasCatalogProfessions mentorHasCatalogProfessions =
                new MentorHasCatalogProfessions();
        copy(object, mentorHasCatalogProfessions);
        return mentorHasCatalogProfessions;
    }

    @Override
    public MentorHasCatalogProfessions map(MentorHasCatalogProfessionsCreateEditDto fromObject,
                      MentorHasCatalogProfessions toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    public void copy(MentorHasCatalogProfessionsCreateEditDto fromObject,
                     MentorHasCatalogProfessions toObject) {
        toObject.setMentorHasCatalogProfessionsId
                (new MentorHasCatalogProfessionsId(
                        fromObject.getMentorId(),
                        fromObject.getCatalogProfessionsId()
                ));
        toObject.setMentor(getMentor(fromObject.getMentorId()));
        toObject.setCatalogProfessions(getCatalogProfessions
                (fromObject.getCatalogProfessionsId()));
    }

    private Mentor getMentor(Integer mentorId) {
        return Optional.ofNullable(mentorId)
                .flatMap(mentorRepository::findById)
                .orElse(null);
    }

    private CatalogProfessions getCatalogProfessions(Integer catalogProfessionsId) {
        return Optional.ofNullable(catalogProfessionsId)
                .flatMap(catalogProfessionsRepository::findById)
                .orElse(null);
    }
}
