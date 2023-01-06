package Main;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Calendrier implements Serializable {
    private Map<LocalDateTime, Activity> calendrier = new TreeMap<>();
    private Set<Personne> listeToutLeMonde = new TreeSet<>();
    public Map<LocalDateTime, Activity> getCalendrier() {
        return calendrier;
    }
    public void ajouterActivite(Activity activity) {
        calendrier.put(activity.getStartTime(), activity);

    }

    public void supprimerActivite(Activity activity){
        calendrier.remove(activity.getStartTime());
    }
    public void ajouterPersonneListe(Personne personne){
        listeToutLeMonde.add(personne);
    }

    public void retirerPersonneListe(Personne p){
        listeToutLeMonde.remove(p);
    }

}




