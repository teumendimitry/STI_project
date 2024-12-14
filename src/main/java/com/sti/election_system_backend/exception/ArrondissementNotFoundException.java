package com.sti.election_system_backend.exception;

public class ArrondissementNotFoundException extends RuntimeException {
    public ArrondissementNotFoundException(String nom) {
        super("Arrondissement non trouvée : " + nom);
    }
}

