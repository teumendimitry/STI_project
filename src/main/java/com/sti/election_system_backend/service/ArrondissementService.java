package com.sti.election_system_backend.service;

import com.sti.election_system_backend.exception.DepartementNotFoundException;
import com.sti.election_system_backend.exception.RegionNotFoundException;
import com.sti.election_system_backend.model.Arrondissement;
import com.sti.election_system_backend.model.Departement;
import com.sti.election_system_backend.model.Region;
import com.sti.election_system_backend.modelDTO.ArrondissementDTO;
import com.sti.election_system_backend.modelDTO.DepartementDTO;
import com.sti.election_system_backend.repository.ArrondissementRepository;
import com.sti.election_system_backend.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArrondissementService {

    public final ArrondissementRepository arrondissementRepository;
    public final DepartementRepository departementRepository;

    @Autowired
    private ArrondissementService(ArrondissementRepository arrondissementRepository, DepartementRepository departementRepository) {
        this.arrondissementRepository = arrondissementRepository;
        this.departementRepository = departementRepository;
    }


    public List<Arrondissement> findAllArrondissements(){
        return arrondissementRepository.findAll();
    }

    public Arrondissement addArrondissement(ArrondissementDTO arrondissementDTO) {
        Arrondissement arrondissement = new Arrondissement();
        arrondissement.setNom(arrondissementDTO.getNom());

        // Récupérer la région par son nom
        Optional<Departement> departementOptional = departementRepository.findByNom(arrondissementDTO.getDepartementNom());

        if (departementOptional.isPresent()) {
            arrondissement.setDepartement(departementOptional.get());
            departementOptional.get().addArrondissement(arrondissement);
        } else {
            throw new DepartementNotFoundException(arrondissementDTO.getDepartementNom());
        }

        return arrondissementRepository.save(arrondissement);
    }

    public Optional<Arrondissement> findArrondissementById(Long id){
        return arrondissementRepository.findById(id);
    }

    public Optional<Arrondissement> findByArrondissementName(String name){
        return arrondissementRepository.findByNom(name);
    }
}
