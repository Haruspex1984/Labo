package controle;

import input.ScannerInput;
import Main.*;
import vues.VueActivite;
import vues.VueCalendrier;

import java.io.*;

public class ControleurGeneral implements Serializable {
    ScannerInput input = new ScannerInput();
    Calendrier calendrier = new Calendrier();
    ControleurActivity controleurActivity = new ControleurActivity(calendrier);
    VueCalendrier vueCalendrier = new VueCalendrier(calendrier);
    VueActivite vueActivite = new VueActivite();
    ControleurCalendrier controleurCalendrier = new ControleurCalendrier(vueCalendrier, calendrier, controleurActivity);

    public void menuGeneral() {

        vueActivite.welcome();

        int userChoice = 0;

        while (userChoice != 4 && userChoice != 5) {
            vueActivite.texteBleu("Menu général");
            System.out.println("""
                    1. Accéder au calendrier des activités.
                    2. Accéder à la gestion des stagiaires. 
                    3. Charger la sauvegarde.
                    4. Sauvegarder et quitter.
                    5. Quitter.
                                        
                    """);
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
                switch (userChoice) {
                    case 1:
                        menuCalendrier();
                        break;
                    case 2:
                        menuStagiaires();
                        break;
                    case 3:
                        calendrier = restauration();
                        break;
                    case 4:
                        sauvegarde();
                        break;
                    case 5:
                        break;
                    default:
                        vueActivite.errorDecoration("Choix invalide");
                }

            } catch (Exception e) {
                System.err.println("Choix invalide");
            }
        }
    }

    public void menuCalendrier() {

        int userChoice = 0;
        int id = 0;

        while (userChoice != 6) {
            vueActivite.texteBleu("Calendrier des activités");
            if (!calendrier.getCalendrier().isEmpty()) {
                System.out.println("""
                        1. Afficher le calendrier.
                        2. Afficher les détails d'une activité.
                        3. Ajouter une activité.
                        4. Modifier une activité.
                        5. Supprimer une activité.
                        6. Revenir au menu général.
                        """);
            } else {
                vueActivite.texteRouge("1. Afficher le calendrier");
                vueActivite.texteRouge("2. Afficher les détails d'une activité");
                vueActivite.texteVert("3. Ajouter une activité.");
                vueActivite.texteRouge("""
                        4. Modifier une activité.
                        5. Supprimer une activité.""");
                vueActivite.texteBleu("6. Revenir au menu général.");
            }
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    vueCalendrier.afficherCalendrier(calendrier);
                    break;
                case 2:
                    menuDetails(calendrier);
                    break;
                case 3:
                    Activity activity = new Activity();
                    controleurActivity.setActivity(activity);
                    controleurActivity.validationActivite(activity, calendrier);
                    break;
                case 4:
                    controleurCalendrier.modifierActivite(calendrier);
                    break;
                case 5:
                    controleurCalendrier.supprimerActivite(calendrier);
                    break;
                case 6:
                    break;
                default:
                    vueActivite.errorDecoration("Choix invalide");
            }
        }

    }

    public void menuStagiaires() {

        int userChoice = 0;

        while (userChoice != 5) {
            vueActivite.texteBleu("Gestion des stagiaires");
            System.out.println("""
                    1. Voir la liste des stagiaires.
                    2. Inscrire un nouveau stagiaire.
                    3. Inscrire un stagiaire à un repas.
                    4. Attribuer un logement à un stagiaire.
                    5. Revenir au menu général.
                    """);
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    vueCalendrier.afficherListeGlobale(calendrier);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }

        }
    }

    public void menuDetails(Calendrier calendrier) {
        vueCalendrier.afficherCalendrier(calendrier);
        int id;
        id = Integer.parseInt(input.read("De quelle activité voulez-vous les détails ? : "));
        Activity activity = controleurCalendrier.getActivityById(id, calendrier);
        vueActivite.afficherActivite(activity);
    }

    public void sauvegarde() throws IOException, IOException {
        FileOutputStream fos = new FileOutputStream("calendrier.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.calendrier);
        oos.close();
        fos.close();
        vueActivite.texteVert("Calendrier sauvegardé.");
    }

    public Calendrier restauration() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("calendrier.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        calendrier = (Calendrier) ois.readObject();
        ois.close();
        fis.close();
        vueActivite.texteVert("Chargement réussi.");
        return calendrier;
    }
}

