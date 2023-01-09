package vues;

import Main.Activity;
import Main.Calendrier;
import Main.Personne;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VueCalendrier {

    // Variables
    Calendrier calendrier;
    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH'h'mm");


    // Constructeur

    public VueCalendrier(Calendrier c) {
        this.calendrier = c;
    }

    // Méthodes

    public void afficherCalendrier(Calendrier calendrier) {
        Activity value;
        if (!calendrier.getCalendrier().isEmpty()) {
            Set<Map.Entry<LocalDateTime, Activity>> entries = calendrier.getCalendrier().entrySet();
            int ind = 1;
            for (Map.Entry<LocalDateTime, Activity> entry : entries) {
                value = entry.getValue();
                String content = ind + ". " + value.getStartTime().format(monFormateur) + " : " + value.getNom() + " avec " + value.getParticipants() + " participant(s)";
                textDecoration(content);
                ind++;
            }
        } else {
            errorDecoration("Le calendrier est actuellement vide");
        }


    }



    public void afficherListeGlobale(Calendrier calendrier){
        for (Personne p:calendrier.getListeGlobale()
             ) {
            System.out.println(p);

        }
    }

    public void textDecoration(String message) {
        message = "| " + message + " |";
        int lenght = message.length();
        String deco = "";
        for (int i = 0; i < lenght; i++) {
            deco = deco + "-";
        }
        System.out.println(deco);
        System.out.println(message);
        System.out.println(deco);
    }

    public void errorDecoration(String message) {
        message = "| " + message + " |";
        int lenght = message.length();
        String deco = "";
        for (int i = 0; i < lenght; i++) {
            deco = deco + "-";
        }
        System.err.println(deco);
        System.err.println(message);
        System.err.println(deco);
    }
}
