package org.tinkoff.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.tinkoff.dto.mentor.MentorCreateEditDto;
import org.tinkoff.dto.mentor.MentorReadDto;
import org.tinkoff.services.MentorService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users/mentors")
@RequiredArgsConstructor
public class MentorController {
    private final MentorService mentorService;

    @GetMapping
    public List<MentorReadDto> findAll() {
        return mentorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MentorReadDto> findById(@PathVariable("id") Integer id) {
        return mentorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MentorReadDto create(MentorCreateEditDto mentor) {
        return mentorService.create(mentor);
    }

    @PutMapping("/{id}")
    public MentorReadDto update(@PathVariable("id") Integer id,
                              MentorCreateEditDto mentor){
        return mentorService
                .update(id, mentor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!mentorService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
