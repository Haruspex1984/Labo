package controle;

import Main.Activity;
import Main.Calendrier;
import input.ScannerInput;
import vues.VueCalendrier;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class ControleurCalendrier implements Serializable {

    ScannerInput input = new ScannerInput();
    VueCalendrier vue;
    ControleurActivity controleurActivity;
    Calendrier calendrier;

    ControleurCalendrier(VueCalendrier vue, Calendrier calendrier, ControleurActivity controleurActivity) {
        this.vue = vue;
        this.calendrier = calendrier;
        this.controleurActivity = controleurActivity;
    }

    public void modifierActivite(Calendrier calendrier) {
        if (calendrier.getCalendrier().isEmpty()) {
            vue.textDecoration("Le calendrier ne contient aucune activité");
        } else {
            Set<Map.Entry<LocalDateTime, Activity>> entries = calendrier.getCalendrier().entrySet();
            vue.afficherCalendrier(calendrier);
            int positionVoulue = Integer.parseInt(input.read("Entrez le numéro de l'activité à modifier : "));
            int positionActuelle = 1;
            Activity activity;
            for (Map.Entry<LocalDateTime, Activity> entry : entries) {
                if (positionActuelle == positionVoulue) {
                    activity = entry.getValue();
                    int userChoice = 0;
                    while (userChoice != 6) {
                        System.out.println("Que souhaitez-vous modifier ?");
                        System.out.println("""
                                1. Nom.
                                2. Date.
                                3. Durée.
                                4. Participants
                                5. Tout.
                                6. Revenir au menu précédent.
                                """);
                        userChoice = Integer.parseInt(input.read("Choix : "));
                        switch (userChoice) {
                            case 1:
                                controleurActivity.setName(activity);
                                break;
                            case 2:
                                controleurActivity.setDate(activity);
                                break;
                            case 3:
                                controleurActivity.setDuration(activity);
                                break;
                            case 4:
                                controleurActivity.menuPersonne(activity);
                                break;
                            case 5:
                                controleurActivity.setActivity(activity);
                                break;
                            case 6:
                                controleurActivity.validationActivite(activity, calendrier);
                                break;
                            default:
                                System.err.println("Choix invalide");
                        }


                    }
                }
                positionActuelle++;
            }
        }
    }

    public void supprimerActivite(Calendrier calendrier) {
        Activity activity;
        if (calendrier.getCalendrier().isEmpty()) {
            vue.textDecoration("Le calendrier ne contient aucune activité");
        } else {
            activity = getActivityById(calendrier);
            calendrier.supprimerActivite(activity);
        }

    }

    public Activity getActivityById(Calendrier calendrier) {
        Set<Map.Entry<LocalDateTime, Activity>> entries = calendrier.getCalendrier().entrySet();
        vue.afficherCalendrier(calendrier);
        int positionVoulue = Integer.parseInt(input.read("Entrez le numéro de l'activité à traiter : "));
        int positionActuelle = 1;
        Activity activity = null;
        for (Map.Entry<LocalDateTime, Activity> entry : entries) {
            if (positionActuelle == positionVoulue) {
                activity = entry.getValue();
                break;
            }

        }
        return activity;
    }

}


