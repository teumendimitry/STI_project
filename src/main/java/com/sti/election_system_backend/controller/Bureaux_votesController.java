package com.sti.election_system_backend.controller;

import com.sti.election_system_backend.model.Arrondissement;
import com.sti.election_system_backend.model.Bureaux_votes;
import com.sti.election_system_backend.modelDTO.ArrondissementDTO;
import com.sti.election_system_backend.modelDTO.Bureaux_votesDTO;
import com.sti.election_system_backend.service.ArrondissementService;
import com.sti.election_system_backend.service.Bureaux_votesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elections/bureauxVotes")
public class Bureaux_votesController {

    private final Bureaux_votesService bureauxVotesService;

    @Autowired
    public Bureaux_votesController(Bureaux_votesService bureauxVotesService) {
        this.bureauxVotesService = bureauxVotesService;
    }


    @GetMapping
    public ResponseEntity<List<Bureaux_votes>> getBureauxVotes() {
        List<Bureaux_votes> bureauxVotes = bureauxVotesService.findAllBureauxVotes();
        return ResponseEntity.ok(bureauxVotes);
    }

    @PostMapping
    public ResponseEntity<Bureaux_votes> addBureauxVote(@Valid @RequestBody Bureaux_votesDTO bureauxVotesDTO) {
        Bureaux_votes createdBureauxVote = bureauxVotesService.addBureauxVotes(bureauxVotesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBureauxVote);
    }

    @GetMapping("/id/{bureauxVotesId}")
    public ResponseEntity<Bureaux_votes> findArrondissementById(@PathVariable Long bureauxVotesId) {
        return bureauxVotesService.findBureauxVotesById(bureauxVotesId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{bureauxVotesName}")
    public ResponseEntity<Bureaux_votes> findByBureauxVoteName(@PathVariable String bureauxVotesName) {
        return bureauxVotesService.findByBureauxVotesName(bureauxVotesName.trim())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
