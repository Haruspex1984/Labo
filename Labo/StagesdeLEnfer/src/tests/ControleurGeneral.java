package tests;

import input.ScannerInput;

public class ControleurGeneral {

    ScannerInput input = new ScannerInput();
    Calendrier calendrier = new Calendrier();
    VueCalendrier vueCalendrier = new VueCalendrier(calendrier);
    VueGenerale vueGenerale = new VueGenerale();

    public void menuGeneral() {

        vueGenerale.welcome();

        int userChoice = 0;


        while (userChoice != 4) {
            System.out.println("""
                    1. Activités.
                    2. Repas.
                    3. Logement.
                    4. Quitter. 
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
                    5. Quitter. 
                    """);
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    newActivity();
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

    public void newActivity() {
        Activity activity = new Activity();
        ControleurActivity ctrlActivity = new ControleurActivity(activity,calendrier);
        ctrlActivity.setActivity();
        menuPersonne(ctrlActivity, activity);
        ctrlActivity.confirmationActivite(activity);
    }

    public void menuPersonne(ControleurActivity ctrl, Activity a) {
        int userChoice = 0;
        while (userChoice != 3) {
            System.out.println("""
                    1. Inscrire une personne à cette activité.
                    2. Retirer une personne de cette activité.
                    3. Quitter.
                    """);
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
                switch (userChoice) {
                    case 1:
                        ctrl.newPersonne(a);
                        break;
                    case 2:
                        System.err.println("En travaux");
                        break;
                    case 3:
                        break;
                    default:
                        System.err.println("Choix invalide");
                }
            } catch (Exception e) {
                System.out.println("Choix invalide");
            }

        }
    }


}
