package com.sti.election_system_backend.repository;

import com.sti.election_system_backend.model.Bureaux_votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Bureaux_votesRepository extends JpaRepository<Bureaux_votes, Long> {
    Optional<Bureaux_votes> findByNom(String nom);
}
