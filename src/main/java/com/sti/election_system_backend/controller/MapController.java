package com.sti.election_system_backend.controller;

import com.sti.election_system_backend.model.Candidat;
import com.sti.election_system_backend.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elections")
public class MapController {

    private final CandidatService candidatService;

    @Autowired
    public MapController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping("/registers")
    public ResponseEntity<Long> getRegisters(){

        return ResponseEntity.ok(null);
    }

    @GetMapping("/voters")
    public ResponseEntity<Long> getVoters(){

        return ResponseEntity.ok(null);
    }

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidat>> getCandidates(){
        List<Candidat> candidats = candidatService.getCandidats();
        return ResponseEntity.ok(candidats);
    }
}
