package Main;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Personne implements Serializable, Comparable<Personne> {

    // Variables d'instances

    private String name = "";
    private String clubName = "";

    private Set<Activity> listeActivites = new HashSet<>();

    // Comparateur

    @Override
    public int compareTo(Personne o) {
        return this.getName().compareTo(o.getName());
    }

    // Equals et hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return name.equals(personne.name) && clubName.equals(personne.clubName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clubName);
    }

    // toString

    @Override
    public String toString() {
        return name;
    }

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

    public void ajouterActivite(Activity activity){
        listeActivites.add(activity);
    }

    public void retirerActivite(Activity activity){
        listeActivites.remove(activity);
    }






}
