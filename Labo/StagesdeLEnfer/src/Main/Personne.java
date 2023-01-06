package Main;

import java.io.Serializable;

public class Personne implements Serializable, Comparable<Personne> {

    // Variables d'instances

    private String name = "";
    private String clubName = "";


    // Comparateur



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

    @Override
    public int compareTo(Personne o) {
        return this.getName().compareTo(o.getName());
    }
}
