package com.sti.election_system_backend.service;

import com.sti.election_system_backend.model.Candidat;
import com.sti.election_system_backend.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    private final CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public List<Candidat> getCandidats(){
        return candidatRepository.findAll();
    }

    public Candidat addCandidat(Candidat candidat){
        return candidatRepository.save(candidat);
    }

    public Optional<Candidat> getCandidatById(Long id){
        return candidatRepository.findById(id);
    }

    public Optional<Candidat> getCandidatByName(String name){
        return candidatRepository.findByNom(name);
    }
}
