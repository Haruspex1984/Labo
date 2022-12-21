package testDates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class TestDate {

    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy : HH:mm");
        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int minute = 0;
        int duration = 0;

        System.out.println("Année de l'activité : ");
        year = scan.nextInt();
        System.out.println("Mois de l'activité : ");
        month = scan.nextInt();
        System.out.println("Jour de l'activité : ");
        day = scan.nextInt();
        System.out.println("Heure de début de l'activité : ");
        hour = scan.nextInt();
        System.out.println("Durée de l'activité en heures : ");
        duration = scan.nextInt();



        String maDate = day+"/"+month+"/"+year+" : "+hour+":"+minute;

        try {
            Date dateActivite = dateFormat.parse(maDate);
            System.out.println(dateFormat.format(dateActivite));
        }catch (ParseException e){
            System.out.println("Date non valide !");
        }






    }





//    public void afficherDate() {
//        LocalDateTime maDate = LocalDateTime.now();
//        DateTimeFormatter monFormateur = DateTimeFormatter.ofPattern("E dd/MM/yyyy : HH:mm:ss");
//        System.out.println(monFormateur.format(maDate));
//    }

//    public Date encodeDate() throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        System.out.println("Saisir une date au format dd-mm-yyyy : ");
//        String maDate = scan.next();
//        Date maDate2 = dateFormat.parse(maDate);
//        return maDate2;
//    }


}


