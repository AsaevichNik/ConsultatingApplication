package org.tinkoff.dto.mentorcatalog;

import lombok.Value;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.dto.mentor.MentorReadDto;

@Value
public class MentorHasCatalogProfessionsReadDto {
    CatalogProfessionsReadDto catalogProfessionsReadDto;
    MentorReadDto mentorReadDto;
}
