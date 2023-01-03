package tests;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Calendrier implements Serializable {


    private Map<LocalDateTime, Activity> calendrier = new TreeMap<>();


    public void ajouterActivite(Activity activity) {
        calendrier.put(activity.getStartTime(), activity);

    }

    public void afficherMap(){
        for (Map.Entry<LocalDateTime, Activity>
                entry : calendrier.entrySet())
            System.out.println(
                    "[" + entry.getKey()
                            + ", " + entry.getValue() + "]");

    }

}




