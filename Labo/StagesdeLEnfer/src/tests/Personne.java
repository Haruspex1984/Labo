package tests;

import java.io.Serializable;

public class Personne implements Serializable {

    // Variables d'instances

    private String name = "";
    private String clubName = "";


    // Constructeur


    // Méthodes

    public void setName(String name) {
        this.name = name;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getName() {
        return name;
    }

    public String getClubName() {
        return clubName;
    }

    @Override
    public String toString() {
        return name;
    }
}
