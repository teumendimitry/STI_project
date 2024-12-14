package com.sti.election_system_backend.repository;

import com.sti.election_system_backend.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    Optional<Candidat> findByNom(String nom);
}