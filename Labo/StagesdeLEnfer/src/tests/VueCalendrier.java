package tests;

import java.time.LocalDateTime;
import java.util.Map;

public class VueCalendrier {
    private Calendrier calendrier;

    VueCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }
    VueActivite vueActivite;

    public void afficherCalendrier(Calendrier cal){
        for(Map.Entry<LocalDateTime,Activity> entry : cal.getCalendrier().entrySet()){
            vueActivite.afficherActivite(entry.getValue());
        }
    }


}

