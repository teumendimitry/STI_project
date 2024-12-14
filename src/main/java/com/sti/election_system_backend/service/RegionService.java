package com.sti.election_system_backend.service;

import com.sti.election_system_backend.model.Region;
import com.sti.election_system_backend.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    public final RegionRepository regionRepository;

    @Autowired
    private RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> findAllRegions(){
        return regionRepository.findAll();
    }

    public Region addRegion(Region region){
        return regionRepository.save(region);
    }

    public Optional<Region> findRegionById(Long id){
        return regionRepository.findById(id);
    }

    public Optional<Region> findByRegionName(String name){
        return regionRepository.findByNom(name);
    }
}
