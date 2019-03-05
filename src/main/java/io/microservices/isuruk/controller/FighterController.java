package io.microservices.isuruk.controller;

import io.microservices.isuruk.entity.Fighter;
import io.microservices.isuruk.exception.ResourceNotFoundException;
import io.microservices.isuruk.service.FighterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FighterController {

    static Logger logger = LoggerFactory.getLogger(FighterController.class);

    @Autowired
    FighterService fighterService;

    //Get all fighters
    @GetMapping("/fighters")
    public List<Fighter> findAllFighter(){
        logger.info("Get all fighters ...");
        return fighterService.findAllFighters();
    }

    //Add new fighter
    @PostMapping(value = "/fighters")
    public Fighter addNewFighter(@Valid @RequestBody Fighter fighter){
        return fighterService.addFighter(fighter);
    }

    //Find a fighter
    @GetMapping(value = "/fighters/{id}")
    public Fighter findTheFighter(@PathVariable(value = "id")Long id){
        return fighterService.findFighterById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Fighter","id",id));
    }

    //Update a fighter
    @PutMapping(value = "/fighters/{id}")
    public Fighter updateTheFighter(@PathVariable("id") Long id,@Valid @RequestBody Fighter updatedEntity){

        Fighter fighter = fighterService.findFighterById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Fighter","id",id));

        fighter.setName(updatedEntity.getName());
        fighter.setOrganization(updatedEntity.getOrganization());
        fighter.setAge(updatedEntity.getAge());

        return fighterService.updateFighter(fighter);
    }

}
