package com.argoden.genesis.controller;

import com.argoden.genesis.dao.dto.SpecieDto;
import com.argoden.genesis.service.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specie")
public class SpecieController {

    SpecieService specieService;

    @Autowired
    public SpecieController(SpecieService specieService) {
        this.specieService = specieService;
    }

    @GetMapping("/")
    public List<SpecieDto> getAllSpecies() {
        return specieService.getAllSpecies();
    }

    @GetMapping("/{id}")
    public SpecieDto getSpecie(@PathVariable Long id) {
        return specieService.getSpecie(id);
    }

    @PostMapping("/make")
    public SpecieDto makeSpecie(@RequestBody SpecieDto dto ) {
        return specieService.makeSpecie(dto);
    }
}
