package com.sti.election_system_backend.modelDTO;

public class Bureaux_votesDTO {
    private String nom;
    private String ArrondissementNom;

    public String getArrondissementNom() {
        return ArrondissementNom;
    }

    public void setArrondissementNom(String arrondissementNom) {
        ArrondissementNom = arrondissementNom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
