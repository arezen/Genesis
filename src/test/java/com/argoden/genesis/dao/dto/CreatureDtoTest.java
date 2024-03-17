package com.argoden.genesis.dao.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreatureDtoTest {

    SpecieDto specie = SpecieDto.builder()
            .rnaLength(10)
            .maxChildren(1)
            .maxMutations(1)
            .build();

//    @Test
//    @DisplayName("Perfect score")
//    void blah() {
//        CreatureDto creatureDto = CreatureDto.builder()
//                .specie(specie)
//                .build();
//
//        System.out.println(creatureDto.getScore() + ":" + creatureDto.getRna());
//
//        creatureDto.mutate();
//
//        System.out.println(creatureDto.getScore() + ":" + creatureDto.getRna());
//    }

    @Test
    @DisplayName("Perfect score")
    void testReproduction() {
        CreatureDto parent = CreatureDto.builder()
                .id(19L)
                .age(0)
                .specie(specie)
                .build();

        CreatureDto child = parent.reproduce();
        System.out.println(parent.getAge());
        System.out.println(child.getScore() + ":" + child.getRna());
    }

}
