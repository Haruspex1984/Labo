package tests;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Activity activity = new Activity();
        Calendrier calendrier = new Calendrier();
        VueActivite vue = new VueActivite(activity);
        ControleurActivity ctrl = new ControleurActivity(vue, activity,calendrier);

        vue.welcome();

        ctrl.run();
        ctrl.run();
        calendrier.afficherMap();




//        Personne personne1 = new Personne("Jean", "Forem");
//        Personne personne2 = new Personne("Charlotte", "Java Team");
//
//        activity.ajouterPersonneListe(personne1);
//        activity.ajouterPersonneListe(personne2);
//
//        activity.setNom("Football");
//        activity.setStartTime(2022,12,31,18,30);
//        activity.setDuration(3);
//        activity.setEndTime();
//
//        calendrier.ajouterActivite(activity);
//
//        vue.afficherActivite(calendrier.getValueByKey(0));


//        FileOutputStream fos = new FileOutputStream("calendrier.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(calendrier);
//        oos.close();
//        fos.close();

//        FileInputStream fis = new FileInputStream("calendrier.bin");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Calendrier calendrier1 = (Calendrier) ois.readObject();
//        ois.close();
//        fis.close();
////
//        vue.afficherActivite(calendrier1.getValueByKey(0));

    }
}




