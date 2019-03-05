package io.microservices.isuruk.service;

import io.microservices.isuruk.entity.Fighter;
import io.microservices.isuruk.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    @Autowired
    FighterRepository fighterRepository;

    public Fighter addFighter(Fighter fighter){
        return fighterRepository.save(fighter);
    }

    public List<Fighter> findAllFighters(){
        return fighterRepository.findAll();
    }

    public Fighter updateFighter(Fighter fighter){
        return fighterRepository.save(fighter);
    }

    public Optional<Fighter> findFighterById(Long id){
        return fighterRepository.findById(id);
    }


}
