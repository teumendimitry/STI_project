package com.sti.election_system_backend.controller;

import com.sti.election_system_backend.model.Departement;
import com.sti.election_system_backend.modelDTO.DepartementDTO;
import com.sti.election_system_backend.service.DepartementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/elections/departements")
public class DepartementController {

    private final DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public ResponseEntity<List<Departement>> getDepartements() {
        List<Departement> departements = departementService.findAllDepartements();
        return ResponseEntity.ok(departements);
    }

    @PostMapping
    public ResponseEntity<Departement> addDepartement(@Valid @RequestBody DepartementDTO departementDTO) {
        Departement createdDepartement = departementService.addDepartement(departementDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartement);
    }

    @GetMapping("/id/{departementId}")
    public ResponseEntity<Departement> findDepartementById(@PathVariable Long departementId) {
        return departementService.findDepartementById(departementId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{departementName}")
    public ResponseEntity<Departement> findByDepartementName(@PathVariable String departementName) {
        return departementService.findByDepartementName(departementName.trim())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
