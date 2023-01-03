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
        System.out.println("Date et heure de fin de l'activité : "+activity.getEndTime().format(monFormateur));
        System.out.println("Nombre de participants : "+activity.getParticipants());
    }


    public void welcome(){
        System.out.println("""
                  ___                           _              \s
                 / _ \\                         | |             \s
                / /_\\ \\  __ _   ___  _ __    __| |  __ _       \s
                |  _  | / _` | / _ \\| '_ \\  / _` | / _` |      \s
                | | | || (_| ||  __/| | | || (_| || (_| |      \s
                \\_| |_/_\\__, | \\___||_| |_| \\__,_| \\__,_|      \s
                |  \\/  | __/ |                                 \s
                | .  . ||___/_  _ __    __ _   __ _   ___  _ __\s
                | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|
                | |  | || (_| || | | || (_| || (_| ||  __/| |  \s
                \\_|  |_/ \\__,_||_| |_| \\__,_| \\__, | \\___||_|  \s
                                               __/ |           \s
                                              |___/            \s
                """);
    }
}
