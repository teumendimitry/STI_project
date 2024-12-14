package com.sti.election_system_backend.exception;

public class DepartementNotFoundException extends RuntimeException {
    public DepartementNotFoundException(String nom) {
        super("Departement non trouvée : " + nom);
    }
}

