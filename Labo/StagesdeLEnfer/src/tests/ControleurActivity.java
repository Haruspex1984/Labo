package tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleurActivity {

    Scanner scan = new Scanner(System.in);
    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH':'mm");
    private Activity activity;
    private VueActivite vue;
    private Calendrier calendrier;

    ControleurActivity(VueActivite vue, Activity activity, Calendrier calendrier) {
        this.activity = activity;
        this.vue = vue;
        this.calendrier = calendrier;
    }

    private void setDate() {
        Boolean dateValid = false;
        System.out.println("Date et heure de début de l'activité au format jj/mm/aaaa hh:mm : ");
        while (!dateValid) {
            try {
                String dateUser = scan.nextLine();
                activity.setStartTime(dateUser);
                dateValid = true;
            } catch (Exception e) {
                System.out.println("Date invalide. Veuillez réessayer : ");
            }
        }
    }

    private void setDuration() {
        Boolean durationValid = false;
        System.out.println("Durée de l'activité en heures : ");
        while (!durationValid) {
            try {
                int duration = Integer.parseInt(scan.nextLine());
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
        System.out.println("Nom de l'activité : ");

        while (!nameValid) {
            name = scan.nextLine();
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                nameValid = true;
            } else {
                System.err.println("Nom invalide, réessayez : ");
            }
        }
        activity.setNom(name);
    }

    public void run() {
        setName();
        setDate();
        setDuration();
        activity.setEndTime();
        vue.afficherActivite(activity);
        calendrier.ajouterActivite(activity);
    }
}






