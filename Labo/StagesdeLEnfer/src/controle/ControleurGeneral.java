package controle;

import input.ScannerInput;
import Main.*;
import vues.VueActivite;
import vues.VueCalendrier;

import java.io.*;

public class ControleurGeneral{

    ScannerInput input = new ScannerInput();
    Calendrier calendrier = new Calendrier();
    ControleurActivity controleurActivity = new ControleurActivity(calendrier);
    VueCalendrier vueCalendrier = new VueCalendrier(calendrier);
    VueActivite vueActivite = new VueActivite();


    public void menuGeneral() {

        vueActivite.welcome();

        int userChoice = 0;

        while (userChoice != 5) {
            System.out.println("""
                    1. Activités.
                    2. Repas.
                    3. Logement.
                    4. Charger la sauvegarde.
                    5. Sauvegarder et quitter. 
                    """);
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
                switch (userChoice) {
                    case 1:
                        menuActivite();
                        break;
                    case 2:
                    case 3:
                        System.err.println("En travaux");
                        break;
                    case 4:
                        calendrier = restauration();
                    break;
                    case 5:
                        sauvegarde();
                        break;
                    default:
                        System.err.println("Choix invalide");
                }

            } catch (Exception e) {
                System.err.println("Choix invalide");
            }
        }
    }
    public void menuActivite() {

        int userChoice = 0;

        while (userChoice != 5) {
            System.out.println("""
                    
                    1. Créer une activité.
                    2. Voir les activités.
                    3. Supprimer une activité.
                    4. Prendre les présences.
                    5. Revenir au menu général. 
                    """);
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    Activity activity = new Activity();
                    controleurActivity.setActivity(activity);
                    menuPersonne(controleurActivity, activity);
                    controleurActivity.validationActivite(activity,calendrier);
                    break;
                case 2:
                    vueCalendrier.afficherCalendrier(calendrier);
                    break;
                case 3:
                case 4:
                    System.err.println("En travaux");
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Choix invalide");
            }
        }

    }
    public void menuPersonne(ControleurActivity ctrl, Activity a) {
        int userChoice = 0;
        while (userChoice != 4) {
            System.out.println("""
                    
                    1. Inscrire un participant à cette activité.
                    2. Afficher la liste des participants.
                    3. Retirer un participant.
                    4. Valider la liste des participants.
                    
                    """);
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
                switch (userChoice) {
                    case 1:
                        ctrl.newPersonne(a);
                        break;
                    case 2:
                        vueActivite.afficherListeParticipants(a);
                        break;
                    case 3:
                        ctrl.retirerParticipant(a);
                        break;
                    case 4:
                        break;
                    default:
                        System.err.println("Choix invalide");
                }
            } catch (Exception e) {
                System.out.println("Choix invalide");
            }

        }
    }
    public void sauvegarde() throws IOException, IOException {
        FileOutputStream fos = new FileOutputStream("calendrier.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.calendrier);
        oos.close();
        fos.close();
    }

    public Calendrier restauration() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("calendrier.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        calendrier = (Calendrier) ois.readObject();
        ois.close();
        fis.close();
        return calendrier;
    }
}

