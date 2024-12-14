package com.sti.election_system_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bureaux_votes")
@NoArgsConstructor
@AllArgsConstructor
public class Bureaux_votes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private List<String> Localisation;
    private String registers;
    private String voters;

    @ManyToOne
    @JoinColumn(name = "arrondissement_id")
    @JsonBackReference
    private Arrondissement arrondissement;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(List<String> localisation) {
        Localisation = localisation;
    }

    public String getRegisters() {
        return registers;
    }

    public void setRegisters(String registers) {
        this.registers = registers;
    }

    public String getVoters() {
        return voters;
    }

    public void setVoters(String voters) {
        this.voters = voters;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }
}
