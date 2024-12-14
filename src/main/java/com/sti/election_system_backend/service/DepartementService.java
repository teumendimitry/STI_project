package com.sti.election_system_backend.service;

import com.sti.election_system_backend.exception.RegionNotFoundException;
import com.sti.election_system_backend.model.Departement;
import com.sti.election_system_backend.model.Region;
import com.sti.election_system_backend.modelDTO.DepartementDTO;
import com.sti.election_system_backend.repository.DepartementRepository;
import com.sti.election_system_backend.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    public final DepartementRepository departementRepository;
    public final RegionRepository regionRepository;

    @Autowired
    private DepartementService(DepartementRepository departementRepository, RegionRepository regionRepository) {
        this.departementRepository = departementRepository;
        this.regionRepository = regionRepository;
    }


    public List<Departement> findAllDepartements(){
        return departementRepository.findAll();
    }

    public Departement addDepartement(DepartementDTO departementDTO) {
        Departement departement = new Departement();
        departement.setNom(departementDTO.getNom());

        // Récupérer la région par son nom
        Optional<Region> region = regionRepository.findByNom(departementDTO.getRegionNom());

        if (region.isPresent()) {
            departement.setRegion(region.get());
            region.get().addDepartement(departement); // Ajouter le département à la région
        } else {
            throw new RegionNotFoundException(departementDTO.getRegionNom()); // Lever l'exception
        }

        return departementRepository.save(departement);
    }

    public Optional<Departement> findDepartementById(Long id){
        return departementRepository.findById(id);
    }

    public Optional<Departement> findByDepartementName(String name){
        return departementRepository.findByNom(name);
    }
}
