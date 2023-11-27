package org.tinkoff.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinkoff.database.repository.CatalogProfessionsRepository;
import org.tinkoff.dto.catalog.CatalogProfessionsCreateEditDto;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.mapper.catalog.CatalogProfessionsCreatedEditMapper;
import org.tinkoff.mapper.catalog.CatalogProfessionsReadMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CatalogProfessionsService {
    private final CatalogProfessionsRepository catalogProfessionsRepository;
    private final CatalogProfessionsCreatedEditMapper catalogProfessionsCreatedEditMapper;

    private final CatalogProfessionsReadMapper catalogProfessionsReadMapper;

    public List<CatalogProfessionsReadDto> findAll() {
        return catalogProfessionsRepository
                .findAll()
                .stream()
                .map(catalogProfessionsReadMapper::map)
                .toList();
    }

    public Optional<CatalogProfessionsReadDto> findById(Integer id) {
        return catalogProfessionsRepository
                .findById(id)
                .map(catalogProfessionsReadMapper::map);
    }

    public Optional<CatalogProfessionsReadDto> findByName(String name) {
        return catalogProfessionsRepository
                .findByName(name)
                .map(catalogProfessionsReadMapper::map);
    }

    @Transactional
    public CatalogProfessionsReadDto create(CatalogProfessionsCreateEditDto dto) {
        return Optional.of(dto)
                .map(catalogProfessionsCreatedEditMapper::map)
                .map(catalogProfessionsRepository::save)
                .map(catalogProfessionsReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<CatalogProfessionsReadDto> update(Integer id, CatalogProfessionsCreateEditDto dto) {
        return catalogProfessionsRepository
                .findById(id)
                .map(catalogProfessions ->
                        catalogProfessionsCreatedEditMapper.map(dto, catalogProfessions))
                .map(catalogProfessionsRepository::saveAndFlush)
                .map(catalogProfessionsReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return catalogProfessionsRepository.findById(id)
                .map(mentor -> {
                    catalogProfessionsRepository.delete(mentor);
                    catalogProfessionsRepository.flush();
                    return true;
                })
                .orElse(false);
    }

}
