package tests;

import java.time.format.DateTimeFormatter;

public class VueActivite {

    private Activity model;


    public VueActivite(Activity model){
        this.model = model;
    }
    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH'h'mm");

    public void afficherActivite(Activity activity){
        System.out.println("Nom de l'activité : "+activity.getNom());
        System.out.println("Date et heure du début de l'activité : "+activity.getStartTime().format(monFormateur));
        System.out.println("Durée de l'activité : "+activity.getDuration()+" heure(s)");
    }


    public void welcome(){
        System.out.println("""
                 _______                       __           \s
                |   _   |.-----.-----.-----.--|  |.---.-.   \s
                |       ||  _  |  -__|     |  _  ||  _  |   \s
                |___|___||___  |_____|__|__|_____||___._|   \s
                 _______ |_____|                            \s
                |   |   |.---.-.-----.---.-.-----.-----.----.
                |       ||  _  |     |  _  |  _  |  -__|   _|
                |__|_|__||___._|__|__|___._|___  |_____|__| \s
                                           |_____|          \s  
                """);
    }
}
