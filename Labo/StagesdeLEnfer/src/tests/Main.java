package tests;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Activity activity = new Activity();
        Calendrier calendrier = new Calendrier();
        VueActivite vue = new VueActivite(activity);
        ControleurActivity ctrl = new ControleurActivity(activity);
        vue.welcome();

        ctrl.newActivity();
    }

    public void sauvegarde(Calendrier calendrier) throws IOException {
        FileOutputStream fos = new FileOutputStream("calendrier.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(calendrier);
        oos.close();
        fos.close();
    }

    public Calendrier restauration() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("calendrier.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Calendrier calendrier = (Calendrier) ois.readObject();
        ois.close();
        fis.close();
        return calendrier;
    }


}




