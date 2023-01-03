package tests;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Activity implements Serializable {

    // Variables

    private String nom;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int duration;
    private Set<Personne> listeParticipants = new HashSet<>();

    // Constructeur





    // Méthodes

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime setStartTime(int year, int month, int day, int hour, int minute) {
        startTime = LocalDateTime.of(year, month, day, hour, minute);
        return startTime;
    }

    public void setEndTime() {
        this.endTime = this.startTime.plusHours(duration);
    }

    public void setDuration(int time) {
        this.duration = time;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    public String getNom() {
        return nom;
    }
    public int getDuration() {
        return duration;
    }

    public Set<Personne> getListeParticipants(){
        return this.listeParticipants;
    }

    public void ajouterPersonneListe(Personne p) {
        listeParticipants.add(p);
    }



}


