package org.tinkoff.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.database.entity.MentorHasCatalogProfessionsId;
import org.tinkoff.dto.mentorcatalog.MentorHasCatalogProfessionsCreateEditDto;
import org.tinkoff.dto.mentorcatalog.MentorHasCatalogProfessionsReadDto;
import org.tinkoff.services.MentorHasCatalogProfessionsService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("users/mentor/catalog")
@RequiredArgsConstructor
public class MentorCatalogController {

    private final MentorHasCatalogProfessionsService mentorHasCatalogProfessionsService;

    @GetMapping
    public List<MentorHasCatalogProfessionsReadDto> findAll() {
        return mentorHasCatalogProfessionsService.findAll();
    }

    @GetMapping("/{mentorId}/{catalogId}")
    public Optional<MentorHasCatalogProfessionsReadDto> findById(
            @PathVariable("mentorId") Integer mentorId,
            @PathVariable("catalogId") Integer catalogId) {

        return mentorHasCatalogProfessionsService
                .findById(new MentorHasCatalogProfessionsId(
                    mentorId,
                    catalogId
                )
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MentorHasCatalogProfessionsReadDto create(MentorHasCatalogProfessionsCreateEditDto mentorCatalog) {
        return mentorHasCatalogProfessionsService.create(mentorCatalog);
    }

    @DeleteMapping("/{mentorId}/{catalogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable("mentorId") Integer mentorId,
                        @PathVariable("catalogId") Integer catalogId) {
        if (!mentorHasCatalogProfessionsService.delete
                (new MentorHasCatalogProfessionsId(mentorId, catalogId))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
