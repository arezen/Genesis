package com.argoden.genesis.service;

import com.argoden.genesis.converter.SpecieConverter;
import com.argoden.genesis.dao.dto.SpecieDto;
import com.argoden.genesis.dao.jpa.SpecieJpa;
import com.argoden.genesis.dao.repo.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecieService {

    SpecieRepository repository;

    private final SpecieConverter converter = new SpecieConverter();

    @Autowired
    public SpecieService(SpecieRepository repository) {
        this.repository = repository;
    }

    public List<SpecieDto> getAllSpecies() {
        return converter.toDtoCollection(repository.findAll());
    }

    public SpecieDto getSpecie(Long id) {
        return converter.toDto(repository.getReferenceById(id));
    }

    public SpecieDto makeSpecie(SpecieDto dto) {
        SpecieJpa jpa = converter.toEntity(dto);
        return converter.toDto(repository.save(jpa));
    }

}
