package com.argoden.genesis.dao.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SPECIE")
public class SpecieJpa {
    @Id
    @GeneratedValue(generator = "SPECIE_SEQ")
    @SequenceGenerator(name = "SPECIE_SEQ", sequenceName = "SPECIE_SEQ", allocationSize = 1)
    Long id;
    String name;
    Integer rnaLength;
    Integer maxAge;
    Integer maxChildren;
    Integer maxMutations;

}
