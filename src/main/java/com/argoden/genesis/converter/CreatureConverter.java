package com.argoden.genesis.converter;

import com.argoden.genesis.dao.dto.CreatureDto;
import com.argoden.genesis.dao.jpa.CreatureJpa;

public class CreatureConverter extends BaseConverter<CreatureJpa, CreatureDto> {

    private final SpecieConverter converter = new SpecieConverter();

    @Override
    public CreatureDto toDto(CreatureJpa entity) {
        return CreatureDto.builder()
                .id(entity.getId())
                .age(entity.getAge())
                .rna(entity.getRna())
                .specie(converter.toDto(entity.getSpecie()))
                .name(entity.getName())
                .parentId(entity.getParentId())
                .score(entity.getScore())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public CreatureJpa toEntity(CreatureDto dto) {
        return CreatureJpa.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .rna(dto.getRna())
                .name(dto.getName())
                .parentId(dto.getParentId())
                .score(dto.getScore())
                .specie(converter.toEntity(dto.getSpecie()))
                .status(dto.getStatus())
                .build();
    }
}
