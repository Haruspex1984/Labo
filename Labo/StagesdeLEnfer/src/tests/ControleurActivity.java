package tests;

import input.ScannerInput;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleurActivity {

    private static ScannerInput input = new ScannerInput();

    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH':'mm");
    private Activity activity;

    private Calendrier calendrier;
    private VueActivite vueActivite = new VueActivite(activity);


    ControleurActivity(Activity activity, Calendrier cal) {
        this.activity = activity;
        this.calendrier = cal;
    }

    private void setDate() {
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

    private void setDuration() {
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

    private void setName() {
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

    public void setActivity() {
        setName();
        setDate();
        setDuration();
        activity.setEndTime();
    }

    public void newPersonne(Activity a) {
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
        confirmationPersonne(personne);
    }

    public void confirmationPersonne(Personne p) {
        Boolean confirmed = false;
        int userChoice = 0;
        while (!confirmed) {
            userChoice = Integer.parseInt(input.read("""
                    1. Valider.
                    2. Annuler.
                    """));
            switch (userChoice) {
                case 1:
                    activity.ajouterPersonneListe(p);
                    confirmed = true;
                    break;
                case 2:
                    confirmed = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }

    }

    public void confirmationActivite(Activity a) {
        Boolean confirmed = false;
        int userChoice = 0;
        while (!confirmed) {
            vueActivite.afficherActivite(a);
            System.out.println("Ces informations sont-elles correctes ?");
            userChoice = Integer.parseInt(input.read("""
                    1. Confirmer.
                    2. Annuler.
                    """));
            switch (userChoice) {
                case 1:
                    calendrier.ajouterActivite(a);
                    confirmed = true;
                    break;
                case 2:
                    confirmed = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }

    }

}









