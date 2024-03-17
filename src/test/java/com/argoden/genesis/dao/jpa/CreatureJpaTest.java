package com.argoden.genesis.dao.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreatureJpaTest {

    SpecieJpa specie = SpecieJpa.builder()
            .id(1L)
            .rnaLength(10)
            .maxMutations(1)
            .maxChildren(1)
            .name("virus")
            .build();

    @Test
    @DisplayName("Perfect score")
    void blahBlah() {
        int[] ints = IntStream.range(0, 5).toArray();
        List<Integer> mRna = Arrays.stream(ints).boxed().collect(Collectors.toList());

        Collections.reverse(mRna);

        String rna = mRna.stream().map(String::valueOf).collect(Collectors.joining("|"));

        CreatureJpa jpa = CreatureJpa.builder()
                .id(1L)
                .specie(specie)
                .rna(rna)
                .build();

        System.out.println(jpa.getScore() + " " + jpa.getRna());

    }

}
