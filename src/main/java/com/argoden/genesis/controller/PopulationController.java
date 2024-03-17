package com.argoden.genesis.controller;

import com.argoden.genesis.dao.dto.CreatureDto;
import com.argoden.genesis.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/population")
public class PopulationController {

    PopulationService populationService;

    @Autowired
    PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @PostMapping("/setup")
    List<CreatureDto> setUpPopulation() {
        return populationService.setup();
    }

    @PostMapping("/runOne")
    void runInterval() {
        populationService.runOneInterval();
    }

    @PostMapping("/run")
    void runContinuous() throws InterruptedException {
        populationService.runForever();
    }

    @PostMapping("/kill")
    public void killUnfit() {
        populationService.killUnfit();
    }

}
