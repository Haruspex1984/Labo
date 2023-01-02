package tests;

import personnes.Personne;

public class Main {
    public static void main(String[] args) {

        Activity activity = new Activity();
        VueActivite vue = new VueActivite(activity);
        Calendrier calendrier = new Calendrier();
        VueCalendrier vueCalendrier = new VueCalendrier(calendrier);

        vue.welcome();

        activity.setNom("Football");
        activity.setStartTime(2022,12,31,18,30);
        activity.setDuration(3);
        activity.setEndTime();

        Personne personne1 = new Personne("Jean","Java Team");
        Personne personne2 = new Personne("Charlotte","Forem");

        activity.ajouterPersonneListe(personne1);
        activity.ajouterPersonneListe(personne2);

        calendrier.ajouterActivite(activity);

        vue.afficherActivite(calendrier.getValueByKey(0));


    }
}




