package com.argoden.genesis.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecieDto {
    Long id;
    String name;
    Integer rnaLength;
    Integer maxAge;
    Integer maxChildren;
    Integer maxMutations;
}
