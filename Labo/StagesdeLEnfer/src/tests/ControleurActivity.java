package tests;

import input.ScannerInput;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleurActivity {

    private static ScannerInput input = new ScannerInput();

    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH':'mm");
    private Activity activity;

    ControleurActivity(Activity activity) {
        this.activity = activity;
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

    public void newActivity() {
        setName();
        setDate();
        setDuration();
        activity.setEndTime();


    }
}






