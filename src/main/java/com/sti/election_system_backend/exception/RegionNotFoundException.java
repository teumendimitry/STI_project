package com.sti.election_system_backend.exception;

public class RegionNotFoundException extends RuntimeException {
    public RegionNotFoundException(String nom) {
        super("Région non trouvée : " + nom);
    }
}

