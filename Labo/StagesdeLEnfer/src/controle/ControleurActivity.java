package controle;

import input.ScannerInput;
import Main.Activity;
import Main.Calendrier;
import Main.Personne;
import vues.VueActivite;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleurActivity {

    private static ScannerInput input = new ScannerInput();

    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH':'mm");
    private Calendrier calendrier;
    VueActivite vueActivite = new VueActivite();

    ControleurActivity(Calendrier cal) {
        this.calendrier = cal;
    }

    private void setDate(Activity activity) {
        Boolean dateValid = false;
        while (!dateValid) {
            try {
                activity.setStartTime(input.read("Date et heure de début de l'activité au format jj/mm/aaaa hh:mm : "));
                dateValid = true;
            } catch (Exception e) {
                System.err.println("Date invalide. Veuillez réessayer : ");
            }
        }
    }

    private void setDuration(Activity activity) {
        Boolean durationValid = false;
        while (!durationValid) {
            try {
                int duration = Integer.parseInt(input.read("Durée de l'activité en heures : "));
                activity.setDuration(duration);
                durationValid = true;
            } catch (Exception e) {
                System.err.println("Durée invalide, réessayez : ");
            }
        }


    }

    private void setName(Activity activity) {
        Boolean nameValid = false;
        String regex = "^[a-zA-ZÀ-ÿ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        String name = "";
        while (!nameValid) {
            name = input.read("Nom de l'activité : ");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                nameValid = true;
            } else {
                System.err.println("Nom invalide, réessayez : ");
            }
        }
        activity.setNom(name);
    }

    public void newPersonne(Activity activity) {
        Personne personne = new Personne();
        Boolean nameValid = false;
        String regex = "^[a-zA-ZÀ-ÿ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        String name = "";
        while (!nameValid) {
            name = input.read("Nom de la personne : ");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                nameValid = true;
            } else {
                System.err.println("Nom invalide, réessayez : ");
            }
        }
        personne.setName(name);
        nameValid = false;
        name = "";
        while (!nameValid) {
            name = input.read("Club de la personne : ");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                nameValid = true;
            } else {
                System.err.println("Nom invalide, réessayez : ");
            }
        }
        personne.setClubName(name);
        validationPersonne(activity, personne);
    }

    public void setActivity(Activity activity) {
        setName(activity);
        setDate(activity);
        setDuration(activity);
        activity.setEndTime();
    }

    public void validationPersonne(Activity activity, Personne p) {
        Boolean validation = false;
        int userChoice = 0;
        System.out.println("Inscrire "+p.getName()+" du club '"+p.getClubName()+"' ?");
        System.out.println("""
                1. Valider
                2. Annuler""");
        while (!validation) {
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    activity.ajouterPersonneListe(p);
                    validation = true;
                    break;
                case 2:
                    validation = true;
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
    }

    public void validationActivite(Activity activity) {
        Boolean validation = false;
        int userChoice = 0;
        System.out.println("Ces informations sont-elles correctes ?");
        System.out.println("");
        vueActivite.afficherActivite(activity);
        System.out.println("");
        System.out.println("""
                1. Valider.
                2. Annuler.""");
        while (!validation) {
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
            } catch (Exception e) {
                System.err.println("Veuillez rentrer un chiffre");
            }
            switch (userChoice) {
                case 1:
                    calendrier.ajouterActivite(activity);
                    validation = true;
                    break;
                case 2:
                    validation = true;
                    break;
                default:
                    System.err.println("Choix invalide");
                    break;
            }
        }

    }

    public void retirerParticipant(Activity activity) {
        vueActivite.afficherListeParticipants(activity);
        int positionVoulue;
        int positionActuelle = 0;
        positionVoulue = Integer.parseInt(input.read("Numéro de la personne à retirer : "));
        for (Personne p : activity.getListeParticipants()) {
            if (positionActuelle == positionVoulue) {
                activity.retirerPersonneListe(p);
                break;
            }
            positionActuelle++;
        }
    }
}









