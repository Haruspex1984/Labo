package Main;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Calendrier implements Serializable {

    //Variables
    private Map<LocalDateTime, Activity> calendrier = new TreeMap<>();
    private Set<Personne> listeGlobale = new TreeSet<>();

    // Méthodes
    public Map<LocalDateTime, Activity> getCalendrier() {
        return calendrier;
    }
    public void ajouterActivite(Activity activity) {
        calendrier.put(activity.getStartTime(), activity);

    }

    public void supprimerActivite(Activity activity){
        calendrier.remove(activity.getStartTime());
    }

    public Set<Personne> getListeGlobale(){
        return listeGlobale;
    }
    public void ajouterPersonneListeGlobale(Personne personne){
        listeGlobale.add(personne);
    }

    public void retirerPersonneListe(Personne p){
        listeGlobale.remove(p);
    }

}




