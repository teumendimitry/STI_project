package com.sti.election_system_backend.controller;

import com.sti.election_system_backend.model.Region;
import com.sti.election_system_backend.service.RegionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/elections/regions")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<Region>> getRegions() {
        List<Region> regions = regionService.findAllRegions();
        return ResponseEntity.ok(regions);
    }

    @PostMapping
    public ResponseEntity<Region> addRegion(@Valid @RequestBody Region region) {

        Region createdRegion = regionService.addRegion(region);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRegion);
    }

    @GetMapping("/id/{regionId}")
    public ResponseEntity<Region> findRegionById(@PathVariable Long regionId) {
        return regionService.findRegionById(regionId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{regionName}")
    public ResponseEntity<Region> findByRegionName(@PathVariable String regionName) {
        return regionService.findByRegionName(regionName.trim())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
