package tests;

import input.ScannerInput;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ControleurGeneral ctrlGen = new ControleurGeneral();
        ctrlGen.menuGeneral();

    }


//    public static void sauvegarde(Calendrier calendrier) throws IOException {
//        FileOutputStream fos = new FileOutputStream("calendrier.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(calendrier);
//        oos.close();
//        fos.close();
//    }
//
//    public static Calendrier restauration() throws IOException, ClassNotFoundException {
//        FileInputStream fis = new FileInputStream("calendrier.bin");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Calendrier calendrier = (Calendrier) ois.readObject();
//        ois.close();
//        fis.close();
//        return calendrier;
//    }




}




