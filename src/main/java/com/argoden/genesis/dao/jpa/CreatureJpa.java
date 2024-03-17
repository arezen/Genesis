package com.argoden.genesis.dao.jpa;

import com.argoden.genesis.CreatureStatus;
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
@Table(name = "CREATURE")
public class CreatureJpa {
    @Id
    @GeneratedValue(generator = "CREATURE_SEQ")
    @SequenceGenerator(name = "CREATURE_SEQ", sequenceName = "CREATURE_SEQ", allocationSize = 1)
    Long id;
    Long parentId;
    @ManyToOne
    SpecieJpa specie;
    String name;
    String rna;
    Integer age;
    Integer score;
    CreatureStatus status;

}
