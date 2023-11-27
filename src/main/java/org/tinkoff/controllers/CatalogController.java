package org.tinkoff.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.dto.catalog.CatalogProfessionsCreateEditDto;
import org.tinkoff.dto.catalog.CatalogProfessionsReadDto;
import org.tinkoff.services.CatalogProfessionsService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogProfessionsService catalogProfessionsService;

    @GetMapping
    public List<CatalogProfessionsReadDto> findAll() {
        return catalogProfessionsService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CatalogProfessionsReadDto> findById(@PathVariable("id") Integer id) {
        return catalogProfessionsService.findById(id);
    }

    @GetMapping("/catalog/by_name")
    public Optional<CatalogProfessionsReadDto> findByName(@RequestParam("name") String name) {
        return catalogProfessionsService.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CatalogProfessionsReadDto create(CatalogProfessionsCreateEditDto catalog) {
        return catalogProfessionsService.create(catalog);
    }

    @PutMapping("/{id}")
    public CatalogProfessionsReadDto update(@PathVariable("id") Integer id,
                                CatalogProfessionsCreateEditDto mentor){
        return catalogProfessionsService
                .update(id, mentor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!catalogProfessionsService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
