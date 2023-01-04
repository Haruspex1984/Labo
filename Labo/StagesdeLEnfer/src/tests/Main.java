package tests;

import input.ScannerInput;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        controleurGeneral();

    }

    public static void sauvegarde(Calendrier calendrier) throws IOException {
        FileOutputStream fos = new FileOutputStream("calendrier.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(calendrier);
        oos.close();
        fos.close();
    }

    public static Calendrier restauration() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("calendrier.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Calendrier calendrier = (Calendrier) ois.readObject();
        ois.close();
        fis.close();
        return calendrier;
    }

    public static void controleurGeneral() {

        ScannerInput input = new ScannerInput();
        Activity activity = new Activity();
        ControleurActivity ctrl = new ControleurActivity(activity);
        Calendrier calendrier = new Calendrier();
        VueActivite vue = new VueActivite(activity);
        vue.welcome();

        int userChoice = 0;


        while (userChoice != 4) {
            System.out.println("""
                    1. Activités.
                    2. Repas.
                    3. Logement.
                    4. Quitter. 
                    """);
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    ctrl.menuActivite();
                    break;
                case 2:
                case 3:
                    System.err.println("En travaux");
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Choix invalide");

            }
        }
    }


}




