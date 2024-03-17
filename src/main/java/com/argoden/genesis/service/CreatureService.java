package com.argoden.genesis.service;

import com.argoden.genesis.converter.CreatureConverter;
import com.argoden.genesis.dao.dto.CreatureDto;
import com.argoden.genesis.dao.jpa.CreatureJpa;
import com.argoden.genesis.dao.repo.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureService {

    CreatureRepository creatureRepository;

    private final CreatureConverter converter = new CreatureConverter();

    @Autowired
    CreatureService(CreatureRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public List<CreatureDto> getAllCreatures() {
        return converter.toDtoCollection(creatureRepository.findAll());
    }

    public CreatureDto getCreature(Long creatureId) {
        return converter.toDto(creatureRepository.getReferenceById(creatureId));
    }

    public CreatureDto makeCreature(CreatureDto dto) {
        CreatureJpa entity = converter.toEntity(dto);
        return converter.toDto(creatureRepository.save(entity));
    }
}
