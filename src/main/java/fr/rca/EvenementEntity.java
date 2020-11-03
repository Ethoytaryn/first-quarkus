package fr.rca;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "poc", name = "evenement")
public class EvenementEntity {

    private Long id;

    private String name;

    private LocalDate debut;

    private int duree;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="geEvent")
    @SequenceGenerator(
            name = "geEvent",
            schema = "poc",
            sequenceName = "poc.evenement_id_seq",
            allocationSize = 1)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public void setDebut(LocalDate date) {
        this.debut = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }
}


