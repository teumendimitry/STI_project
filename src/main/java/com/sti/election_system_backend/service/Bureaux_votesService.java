package com.sti.election_system_backend.service;

import com.sti.election_system_backend.exception.ArrondissementNotFoundException;
import com.sti.election_system_backend.exception.DepartementNotFoundException;
import com.sti.election_system_backend.model.Arrondissement;
import com.sti.election_system_backend.model.Bureaux_votes;
import com.sti.election_system_backend.model.Departement;
import com.sti.election_system_backend.modelDTO.ArrondissementDTO;
import com.sti.election_system_backend.modelDTO.Bureaux_votesDTO;
import com.sti.election_system_backend.repository.ArrondissementRepository;
import com.sti.election_system_backend.repository.Bureaux_votesRepository;
import com.sti.election_system_backend.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Bureaux_votesService {

    public final ArrondissementRepository arrondissementRepository;
    public final Bureaux_votesRepository bureauxVotesRepository;

    @Autowired
    private Bureaux_votesService(ArrondissementRepository arrondissementRepository, Bureaux_votesRepository bureauxVotesRepository) {
        this.arrondissementRepository = arrondissementRepository;
        this.bureauxVotesRepository = bureauxVotesRepository;
    }


    public List<Bureaux_votes> findAllBureauxVotes(){
        return bureauxVotesRepository.findAll();
    }

    public Bureaux_votes addBureauxVotes(Bureaux_votesDTO bureauxVotesDTO) {
        Bureaux_votes bureauxVotes = new Bureaux_votes();
        bureauxVotes.setNom(bureauxVotesDTO.getNom());

        // Récupérer la région par son nom
        Optional<Arrondissement> arrondissementOptional = arrondissementRepository.findByNom(bureauxVotesDTO.getArrondissementNom());

        if (arrondissementOptional.isPresent()) {
            bureauxVotes.setArrondissement(arrondissementOptional.get());
            arrondissementOptional.get().addBureaux_votes(bureauxVotes);
        } else {
            throw new ArrondissementNotFoundException(bureauxVotesDTO.getArrondissementNom());
        }

        return bureauxVotesRepository.save(bureauxVotes);
    }

    public Optional<Bureaux_votes> findBureauxVotesById(Long id){
        return bureauxVotesRepository.findById(id);
    }

    public Optional<Bureaux_votes> findByBureauxVotesName(String name){
        return bureauxVotesRepository.findByNom(name);
    }
}
