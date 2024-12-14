package com.sti.election_system_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "departement")
@NoArgsConstructor
@AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonBackReference
    private Region region;

    @OneToMany(mappedBy = "departement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Arrondissement> arrondissements;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Arrondissement> getArrondissements() {
        return arrondissements;
    }

    public void setArrondissements(List<Arrondissement> arrondissements) {
        this.arrondissements = arrondissements;
    }

    public void addArrondissement(Arrondissement arrondissement) {
        if (arrondissement != null){
            arrondissements.add(arrondissement);
            arrondissement.setDepartement(this);
        }
    }

}
