package com.sti.election_system_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "arrondissement")
@NoArgsConstructor
@AllArgsConstructor
public class Arrondissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    @JsonBackReference
    private Departement departement;

    @OneToMany(mappedBy = "arrondissement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Bureaux_votes> bureauxVotes = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Bureaux_votes> getBureauxVotes() {
        return bureauxVotes;
    }

    public void setBureauxVotes(List<Bureaux_votes> bureauxVotes) {
        this.bureauxVotes = bureauxVotes;
    }

    public void addBureaux_votes(Bureaux_votes bureauxVote){
        if (bureauxVote != null){
            bureauxVotes.add(bureauxVote);
            bureauxVote.setArrondissement(this);
        }
    }
}
