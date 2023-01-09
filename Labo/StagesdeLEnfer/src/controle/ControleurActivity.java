package controle;

import input.ScannerInput;
import Main.Activity;
import Main.Calendrier;
import Main.Personne;
import vues.VueActivite;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControleurActivity {

    private static ScannerInput input = new ScannerInput();

    private DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH':'mm");
    private Calendrier calendrier;
    VueActivite vueActivite = new VueActivite();

    // Constructeur



    ControleurActivity(Calendrier cal) {
        this.calendrier = cal;
    }

    public void setDate(Activity activity) {
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

    public void setDuration(Activity activity) {
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

    public void setName(Activity activity) {
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
        menuPersonne(activity);
    }

    public void menuPersonne(Activity activity) {
        int userChoice = 0;
        while (userChoice != 5) {
            System.out.println("""
                                        
                    1. Inscrire un participant à cette activité.
                    2. Retirer un participant.
                    3. Retirer tous les participants.
                    4. Afficher la liste des participants.
                    5. Valider la liste des participants.
                                        
                    """);
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
                switch (userChoice) {
                    case 1:
                        newPersonne(activity);
                        break;
                    case 2:
                        retirerParticipant(activity);
                        break;
                    case 3:
                        viderListe(activity);
                        break;
                    case 4:
                        vueActivite.afficherListeParticipants(activity);
                        break;
                    case 5:
                        break;
                    default:
                        System.err.println("Choix invalide");
                }
            } catch (Exception e) {
                System.out.println("Choix invalide");
            }

        }
    }

    public void validationPersonne(Activity activity, Personne p) {
        Boolean validation = false;
        int userChoice = 0;
        String content = "Inscrire '" + p.getName().toUpperCase() + "' du club '" + p.getClubName().toUpperCase()+"' à l'activité '"+activity.getNom().toUpperCase()+"' ?";
        vueActivite.textDecoration(content);
        vueActivite.texteVert("1. Valider");
        vueActivite.texteRouge("2. Annuler");
        while (!validation) {
            userChoice = Integer.parseInt(input.read("Choix : "));
            switch (userChoice) {
                case 1:
                    activity.ajouterPersonneListe(p);
                    p.ajouterActivite(activity);
                    calendrier.ajouterPersonneListeGlobale(p);
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

    public void validationActivite(Activity activity, Calendrier calendrier) {
        Boolean validation = false;
        int userChoice = 0;
        System.out.println("Ces informations sont-elles correctes ?");
        System.out.println("");
        vueActivite.afficherActivite(activity);
        System.out.println("");
        vueActivite.texteVert("1. Valider");
        vueActivite.texteRouge("2. Annuler");
        System.out.println("");
        while (!validation) {
            try {
                userChoice = Integer.parseInt(input.read("Choix : "));
            } catch (Exception e) {
                System.err.println("Veuillez rentrer un chiffre !");
            }
            switch (userChoice) {
                case 1:
                    calendrier.ajouterActivite(activity);
                    vueActivite.texteVert("L'activité a été ajoutée au calendrier");
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
        int positionActuelle = 1;
        int positionVoulue = Integer.parseInt(input.read("Numéro de la personne à retirer : "));
        for (Personne p : activity.getListeParticipants()) {
            if (positionActuelle == positionVoulue) {
                activity.retirerPersonneListe(p);
                p.retirerActivite(activity);
                break;
            }
            positionActuelle++;
        }
    }

    public void viderListe(Activity activity) {
        Boolean validation = false;
        int userChoice = Integer.parseInt(input.read("""
                Souhaitez-vous vraiment supprimer tous les participants de cette activité ?
                1. Oui.
                2. Non."""));
        while (!validation) {
            switch (userChoice) {
                case 1:
                    activity.viderListe();
                    validation = true;
                    break;
                case 2:
                    validation = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }


    }


}









