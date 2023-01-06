package Main;

import controle.ControleurGeneral;



public class Main {
    public static void main(String[] args){

        ControleurGeneral ctrlGen = new ControleurGeneral();
        ctrlGen.menuGeneral();
    }



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




