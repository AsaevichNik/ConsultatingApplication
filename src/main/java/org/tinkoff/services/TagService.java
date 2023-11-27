package org.tinkoff.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tinkoff.database.repository.TagRepository;
import org.tinkoff.dto.tag.TagCreateEditDto;
import org.tinkoff.dto.tag.TagReadDto;
import org.tinkoff.mapper.tag.TagCreateEditMapper;
import org.tinkoff.mapper.tag.TagReadMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {

    private final TagRepository tagRepository;
    private final TagCreateEditMapper tagCreateEditMapper;
    private final TagReadMapper tagReadMapper;


    public Optional<TagReadDto> findById(Integer id) {
        return tagRepository
                .findById(id)
                .map(tagReadMapper::map);
    }

    public List<TagReadDto> findAll() {
        return tagRepository
                .findAll()
                .stream()
                .map(tagReadMapper::map)
                .toList();
    }


    @Transactional
    public TagReadDto create(TagCreateEditDto tagDto) {
        return Optional.of(tagDto)
                .map(tagCreateEditMapper::map)
                .map(tagRepository::save)
                .map(tagReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<TagReadDto> update(Integer id, TagCreateEditDto tagCreateEditDto) {
        return tagRepository
                .findById(id)
                .map(tag -> tagCreateEditMapper.map(tagCreateEditDto, tag))
                .map(tagRepository::saveAndFlush)
                .map(tagReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return tagRepository.findById(id)
                .map(user -> {
                    tagRepository.delete(user);
                    tagRepository.flush();
                    return true;
                })
                .orElse(false);
    }

}
