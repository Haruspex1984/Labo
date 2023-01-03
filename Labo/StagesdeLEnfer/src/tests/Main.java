package tests;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Activity activity = new Activity();
        VueActivite vue = new VueActivite(activity);
        Calendrier calendrier = new Calendrier();
        VueCalendrier vueCalendrier = new VueCalendrier(calendrier);

        vue.welcome();

//        activity.setNom("Football");
//        activity.setStartTime(2022,12,31,18,30);
//        activity.setDuration(3);
//        activity.setEndTime();
//
//        Personne personne1 = new Personne("Jean","Java Team");
//        Personne personne2 = new Personne("Charlotte","Forem");
//
//        activity.ajouterPersonneListe(personne1);
//        activity.ajouterPersonneListe(personne2);
//
//        calendrier.ajouterActivite(activity);
//
//        vue.afficherActivite(calendrier.getValueByKey(0));
//
//        FileOutputStream fos = new FileOutputStream("calendrier.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(calendrier);
//        fos.close();
//        oos.close();

        FileInputStream fis = new FileInputStream("calendrier.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Calendrier calendrier1 = (Calendrier) ois.readObject();

        ois.close();
        fis.close();

        vue.afficherActivite(calendrier1.getValueByKey(0));


    }
}




