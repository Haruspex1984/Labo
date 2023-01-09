package vues;

import Main.Activity;
import Main.Personne;

import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class VueActivite {

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
        int ind = 1;
        while (it.hasNext()) {
            System.out.println(ind + ". " + it.next());
            ind++;
        }
    }

    public void welcome() {
        System.out.println("""

                                              _                      \s
                    /\\                       | |                     \s
                   /  \\   __ _  ___ _ __   __| | __ _                \s
                  / /\\ \\ / _` |/ _ \\ '_ \\ / _` |/ _` |               \s
                 / ____ \\ (_| |  __/ | | | (_| | (_| |               \s
                /_/  __\\_\\__, |\\___|_| |_|\\__,_|\\__,_|      __   ___ \s
                |  \\/  |  __/ |                            /_ | / _ \\\s
                | \\  / | |___/_ __   __ _  __ _  ___ _ __   | || | | |
                | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|  | || | | |
                | |  | | (_| | | | | (_| | (_| |  __/ |     | || |_| |
                |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|     |_(_)___/\s
                                           __/ |                     \s
                                          |___/                      \s

                               """);
    }

    public void textDecoration(String message){
        message = "| "+message+" |";
        int lenght = message.length();
        String deco = "";
        for (int i=0;i<lenght;i++){
            deco = deco+"-";
        }
        System.out.println(deco);
        System.out.println(message);
        System.out.println(deco);
    }

    public void errorDecoration(String message){
        message = "| "+message+" |";
        int lenght = message.length();
        String deco = "";
        for (int i=0;i<lenght;i++){
            deco = deco+"-";
        }
        System.err.println(deco);
        System.err.println(message);
        System.err.println(deco);
    }
}




