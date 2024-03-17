package com.argoden.genesis.controller;


import com.argoden.genesis.dao.dto.CreatureDto;
import com.argoden.genesis.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creature")
public class CreatureController {

    CreatureService creatureService;

    @Autowired
    CreatureController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }


    @GetMapping("/all")
    public List<CreatureDto> getAll() {
        return creatureService.getAllCreatures();
    }

    @GetMapping("/{id}")
    public CreatureDto getCreature(@PathVariable String id) {
        return creatureService.getCreature(Long.parseLong(id));
    }

    @PostMapping("/make")
    public CreatureDto make(@RequestBody CreatureDto dto) {
        return creatureService.makeCreature(dto);
    }

}
