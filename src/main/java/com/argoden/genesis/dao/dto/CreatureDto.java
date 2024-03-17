package com.argoden.genesis.dao.dto;

import com.argoden.genesis.CreatureStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreatureDto {

    @JsonIgnore
    private final static Random random = new Random();

    Long id;
    Long parentId;
    SpecieDto specie;
    String name;
    String rna;
    Integer age;
    Integer score;
    CreatureStatus status;

    public String getRna() {
       if (this.rna == null) {
           this.rna = this.initRna();
       }

       return this.rna;
    }

    public Integer getScore() {
        this.score = 0;
        int idx = 0;
        for (String s : unpackRna()) {
            if (Integer.valueOf(s) == idx) {
                this.score++;
            }
//
//            this.score += Math.abs(Integer.valueOf(s) - idx);
//            this.score += Math.abs(Integer.valueOf(s) - idx);
            idx++;
        }

        return score;
    }

    private CreatureDto mutate() {
        int max = getSpecie().getRnaLength();
        int to   = random.nextInt(max);
        int from = random.nextInt(max);

        String[] unpackedRna = unpackRna();

        String n1 = unpackedRna[from];
        String n2 = unpackedRna[to];

        unpackedRna[from] = n2;
        unpackedRna[to] = n1;

        this.rna = packRna(unpackedRna);

        return this;
    }

    public CreatureDto reproduce() {

        CreatureDto dto =  CreatureDto.builder()
                .age(0)
                .specie(this.getSpecie())
                .rna(this.getRna())
                .parentId(this.getId())
                .status(CreatureStatus.ALIVE)
                .build();

        for (int i = 0; i < specie.getMaxMutations(); i++) {
            dto.mutate();
        }

        return dto;
    }

    private String[] unpackRna() {
        return this.getRna().split("\\|");
    }

    public String packRna(String[] unpackedRna) {
        return String.join("|", unpackedRna);
    }

    private String packRna(List<Integer> unpackedRna) {
        return unpackedRna.stream().map(String::valueOf).collect(Collectors.joining("|"));
    }

    private String initRna() {
        int[] ints = IntStream.range(0, this.specie.getRnaLength()).toArray();
        List<Integer> mRna = Arrays.stream(ints).boxed().collect(Collectors.toList());
        Collections.shuffle(mRna);
        return packRna(mRna);
    }
}
