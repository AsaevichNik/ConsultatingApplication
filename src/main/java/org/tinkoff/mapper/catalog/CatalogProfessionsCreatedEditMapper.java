package org.tinkoff.mapper.catalog;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.CatalogProfessions;
import org.tinkoff.dto.catalog.CatalogProfessionsCreateEditDto;
import org.tinkoff.mapper.Mapper;

@Component
public class CatalogProfessionsCreatedEditMapper implements
        Mapper<CatalogProfessionsCreateEditDto, CatalogProfessions> {

    @Override
    public CatalogProfessions map(CatalogProfessionsCreateEditDto object) {
        CatalogProfessions catalogProfessions = new CatalogProfessions();
        catalogProfessions.setName(object.getName());
        return catalogProfessions;
    }

    @Override
    public CatalogProfessions map(CatalogProfessionsCreateEditDto fromObject,
                                  CatalogProfessions toObject) {
        toObject.setName(fromObject.getName());
        return toObject;
    }
}
