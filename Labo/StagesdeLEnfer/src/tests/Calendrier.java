package tests;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Calendrier implements Serializable {




    private Map<LocalDateTime, Activity> calendrier = new TreeMap<>();

    public Map<LocalDateTime, Activity> getCalendrier() {
        return calendrier;
    }


    public void ajouterActivite(Activity activity) {
        calendrier.put(activity.getStartTime(), activity);
        System.out.println("Ajout réussi");

    }


}




