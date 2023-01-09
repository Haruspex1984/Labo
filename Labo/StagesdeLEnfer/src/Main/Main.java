package Main;

import controle.ControleurGeneral;

import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args){
        ControleurGeneral ctrlGen = new ControleurGeneral();
        ctrlGen.menuGeneral();
    }
}




