package vues;

import Main.Activity;
import Main.Calendrier;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;

public class VueCalendrier {
    Calendrier calendrier;
    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH'h'mm");

    public VueCalendrier(Calendrier c) {
        this.calendrier = c;
    }

    public void afficherCalendrier() {
        Set<Map.Entry<LocalDateTime, Activity>> entries = calendrier.getCalendrier().entrySet();
        int ind = 1;
        for (Map.Entry<LocalDateTime, Activity> entry : entries) {
            Activity value = entry.getValue();
            String content = "| "+ind+". "+value.getStartTime().format(monFormateur)+" : "+value.getNom()+" |";
            int lenght = content.length();
            String deco = "";
            for(int i = 0;i<lenght;i++){
                deco = deco+"-";
            }
            String canevas = ".";
            String display = canevas.replace(".",content);
            System.out.println(deco);
            System.out.println(display);
            System.out.println(deco);
            ind++;
        }
    }
}
