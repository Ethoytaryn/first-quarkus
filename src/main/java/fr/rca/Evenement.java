package fr.rca;

import java.time.LocalDate;

public class Evenement {

    public Evenement(final Long id, final String name, final LocalDate debut, final int duree){
        this.setId(id);
        this.setNom(name);
        this.setDebut(debut);
        this.setDuree(duree);
    }

    private Long id;

    private String nom;

    private LocalDate debut;

    private int duree;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
