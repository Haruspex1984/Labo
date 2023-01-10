package controle;

import Main.Activity;
import Main.Calendrier;
import input.ScannerInput;
import vues.VueActivite;
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
    VueActivite vueActivite = new VueActivite();

    ControleurCalendrier(VueCalendrier vue, Calendrier calendrier, ControleurActivity controleurActivity) {
        this.vue = vue;
        this.calendrier = calendrier;
        this.controleurActivity = controleurActivity;
    }

    public void modifierActivite(Calendrier calendrier) {
        if (calendrier.getCalendrier().isEmpty()) {
            vue.errorDecoration("Le calendrier ne contient aucune activité");
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
                    Boolean validation = false;
                    while (!validation) {
                        vueActivite.afficherActivite(activity);
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
                                controleurActivity.validationActivite(activity, calendrier);
                                validation = true;
                                break;
                            case 2:
                                controleurActivity.setDate(activity);
                                controleurActivity.validationActivite(activity, calendrier);
                                validation = true;
                                break;
                            case 3:
                                controleurActivity.setDuration(activity);
                                controleurActivity.validationActivite(activity, calendrier);
                                validation = true;
                                break;
                            case 4:
                                controleurActivity.menuPersonne(activity);
                                controleurActivity.validationActivite(activity, calendrier);
                                validation = true;
                                break;
                            case 5:
                                controleurActivity.setActivity(activity);
                                controleurActivity.validationActivite(activity, calendrier);
                                validation = true;
                                break;
                            case 6:
                                validation = true;
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
        int id;
        if (calendrier.getCalendrier().isEmpty()) {
            vue.errorDecoration("Le calendrier ne contient aucune activité");
        } else {
            vue.afficherCalendrier(calendrier);
            id = Integer.parseInt(input.read("Quelle activité souhaitez-vous supprimer ? "));
            activity = getActivityById(id, calendrier);
            calendrier.supprimerActivite(activity);
        }

    }

    public Activity getActivityById(int id, Calendrier calendrier) {
        Set<Map.Entry<LocalDateTime, Activity>> entries = calendrier.getCalendrier().entrySet();
        int positionVoulue = id;
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


