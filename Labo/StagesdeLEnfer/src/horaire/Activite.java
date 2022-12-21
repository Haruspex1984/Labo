package horaire;

import java.util.Date;

public class Activite {

    // Variables d'instances

    private String name = "";
    public Date dateDebut = null;
    public Date dateFin = null;
    private int nbParticipants = 0;


    // Méthodes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNbParticipants() {
        return nbParticipants;
    }

    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }
}


