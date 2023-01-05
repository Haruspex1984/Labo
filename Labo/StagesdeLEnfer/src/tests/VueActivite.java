package tests;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

public class VueActivite {

    private Activity activity;

    public VueActivite(Activity activity) {
        this.activity = activity;
    }

    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH'h'mm");

    public void afficherActivite(Activity activity) {
        System.out.println("");
        System.out.println("Nom de l'activité : " + activity.getNom());
        System.out.println("Date et heure du début de l'activité : " + activity.getStartTime().format(monFormateur));
        System.out.println("Durée de l'activité : " + activity.getDuration() + " heure(s)");
        System.out.println("Date et heure de fin de l'activité : " + activity.getEndTime().format(monFormateur));
        System.out.println("Nombre de participants : " + activity.getParticipants());
        afficherListeParticipants(activity);
        System.out.println("");
    }

    public void afficherListeParticipants(Activity activity) {
       Iterator<Personne> it = activity.getListeParticipants().iterator();
       int ind =1;
       while(it.hasNext()){
           System.out.println(ind+". "+it.next());
           ind++;

        }

    }
}




