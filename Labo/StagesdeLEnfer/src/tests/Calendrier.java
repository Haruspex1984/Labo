package tests;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Calendrier implements Serializable {

    private int id;

    private Map<Integer, Activity> calendrier = new TreeMap<>();

    public void ajouterActivite(Activity activity) {
        calendrier.put(id, activity);
        id++;
    }

    public void retirerActivite(int id) {
        calendrier.remove(id);
        this.id--;
    }

    public Activity getValueByKey(int id){
        return calendrier.get(id);
    }




}




