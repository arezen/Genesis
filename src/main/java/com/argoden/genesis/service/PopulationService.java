package com.argoden.genesis.service;

import com.argoden.genesis.CreatureStatus;
import com.argoden.genesis.converter.CreatureConverter;
import com.argoden.genesis.converter.SpecieConverter;
import com.argoden.genesis.dao.dto.CreatureDto;
import com.argoden.genesis.dao.repo.CreatureRepository;
import com.argoden.genesis.dao.repo.SpecieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopulationService {

    CreatureRepository creatureRepository;
    SpecieRepository specieRepository;

    private final int maxPopulation = 100;
    private final int maxSurvivors = 5;

    private final SpecieConverter specieConverter = new SpecieConverter();
    private final CreatureConverter creatureConverter = new CreatureConverter();

    PopulationService(CreatureRepository creatureRepository, SpecieRepository specieRepository) {
        this.creatureRepository = creatureRepository;
        this.specieRepository = specieRepository;
    }

    public List<CreatureDto> setup() {

        specieRepository.getReferenceById(1L);

        List<CreatureDto> creatures = new ArrayList<>();
        for (int i = 0; i < maxPopulation; i++) {
            creatures.add(
                    CreatureDto.builder()
                            .age(0)
                            .parentId(0L)
                            .specie(specieConverter.toDto(specieRepository.getReferenceById(1L)))
                            .status(CreatureStatus.ALIVE)
                            .build()
            );
        }

       return creatureConverter.toDtoCollection(
               creatureRepository.saveAll(creatureConverter.toEntityCollection(creatures))
       );
    }

    public void runOneInterval() {
        List<CreatureDto> creatures = creatureConverter.toDtoCollection(
                creatureRepository.findAllByStatusOrderByScoreAsc(CreatureStatus.ALIVE)
        );

        ArrayList<CreatureDto> newGeneration = new ArrayList<>();
        creatures.forEach( creature -> {
            for (int i = 0; i < creature.getSpecie().getMaxChildren(); i++) {
                newGeneration.add(creature.reproduce());
            }
            creature.setAge(creature.getAge() + 1);
            newGeneration.add(creature);
        });

        creatureRepository.saveAll(creatureConverter.toEntityCollection(newGeneration));

        killUnfit();
    }


    public void killUnfit() {
        List<CreatureDto> creatures = creatureConverter.toDtoCollection(
                creatureRepository.findAllUnfit(maxSurvivors)
        );

        creatureRepository.deleteAll(creatureConverter.toEntityCollection(creatures));
    }

    public void runForever() throws InterruptedException {
        int max = 100000000;
        for (int i = 0; i < max; i++) {
            runOneInterval();
            System.out.println("GenerationNumber:" + i);
            Thread.sleep(10);
        }
    }
}
