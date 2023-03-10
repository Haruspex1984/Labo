package Main;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Activity implements Serializable {

    // Variables

    private String nom;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int duration;
    private Set<Personne> listeParticipants = new HashSet<>();
    private int participants = 0;

    // Constructeur


    // Méthodes

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setStartTime(String date) {
        DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH':'mm");
        startTime = LocalDateTime.parse(date, monFormateur);
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

    public Set<Personne> getListeParticipants() {
        return this.listeParticipants;
    }

    public void ajouterPersonneListe(Personne p) {
        listeParticipants.add(p);
        participants++;
    }

    public void viderListe(){
        listeParticipants.clear();
        participants = 0;
    }

    public void retirerPersonneListe(Personne p){
        listeParticipants.remove(p);
        participants--;
    }

    public int getParticipants() {
        return participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return getStartTime().equals(activity.getStartTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartTime());
    }
}


