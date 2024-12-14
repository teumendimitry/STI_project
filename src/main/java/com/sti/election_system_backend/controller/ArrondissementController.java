package com.sti.election_system_backend.controller;

import com.sti.election_system_backend.model.Arrondissement;
import com.sti.election_system_backend.model.Departement;
import com.sti.election_system_backend.modelDTO.ArrondissementDTO;
import com.sti.election_system_backend.modelDTO.DepartementDTO;
import com.sti.election_system_backend.service.ArrondissementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elections/arrondissements")
public class ArrondissementController {

    private final ArrondissementService arrondissementService;

    @Autowired
    public ArrondissementController(ArrondissementService arrondissementService) {
        this.arrondissementService = arrondissementService;
    }

    @GetMapping
    public ResponseEntity<List<Arrondissement>> getArrondissements() {
        List<Arrondissement> arrondissements = arrondissementService.findAllArrondissements();
        return ResponseEntity.ok(arrondissements);
    }

    @PostMapping
    public ResponseEntity<Arrondissement> addDepartement(@Valid @RequestBody ArrondissementDTO arrondissementDTO) {
        Arrondissement createdArrondissement = arrondissementService.addArrondissement(arrondissementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArrondissement);
    }

    @GetMapping("/id/{arrondissementId}")
    public ResponseEntity<Arrondissement> findArrondissementById(@PathVariable Long arrondissementId) {
        return arrondissementService.findArrondissementById(arrondissementId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{arrondissementName}")
    public ResponseEntity<Arrondissement> findByArrondissementName(@PathVariable String arrondissementName) {
        return arrondissementService.findByArrondissementName(arrondissementName.trim())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
