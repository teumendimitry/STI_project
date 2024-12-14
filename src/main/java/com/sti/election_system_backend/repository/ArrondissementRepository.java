package com.sti.election_system_backend.repository;

import com.sti.election_system_backend.model.Arrondissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArrondissementRepository extends JpaRepository<Arrondissement, Long> {
    Optional<Arrondissement> findByNom(String nom);
}
