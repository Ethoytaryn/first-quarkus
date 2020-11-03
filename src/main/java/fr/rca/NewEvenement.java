package fr.rca;

import java.time.LocalDate;

public class NewEvenement {

    public NewEvenement(final String name, final LocalDate debut, final int duree){
        this.nom = name;
        this.debut = debut;
        this.duree = duree;
    }

    private String nom;

    private LocalDate debut;

    private int duree;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}
