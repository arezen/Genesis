package com.argoden.genesis.converter;

import com.argoden.genesis.dao.dto.SpecieDto;
import com.argoden.genesis.dao.jpa.SpecieJpa;

public class SpecieConverter extends BaseConverter<SpecieJpa, SpecieDto> {

    @Override
    public SpecieDto toDto(SpecieJpa entity) {
        return SpecieDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .rnaLength(entity.getRnaLength())
                .maxChildren(entity.getMaxChildren())
                .maxAge(entity.getMaxAge())
                .maxMutations(entity.getMaxMutations())
                .build();
    }

    @Override
    public SpecieJpa toEntity(SpecieDto dto) {
        return SpecieJpa.builder()
                .id(dto.getId())
                .name(dto.getName())
                .rnaLength(dto.getRnaLength())
                .maxChildren(dto.getMaxChildren())
                .maxAge(dto.getMaxAge())
                .maxMutations(dto.getMaxMutations())
                .build();
    }
}
