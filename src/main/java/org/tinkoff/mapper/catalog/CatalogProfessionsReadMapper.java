package org.tinkoff.mapper.catalog;


import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.CatalogProfessions;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.mapper.Mapper;

@Component
public class CatalogProfessionsReadMapper implements
        Mapper<CatalogProfessions, CatalogProfessionsReadDto> {

    @Override
    public CatalogProfessionsReadDto map(CatalogProfessions object) {
        return new CatalogProfessionsReadDto(
                object.getId(),
                object.getName()
        );
    }
}
