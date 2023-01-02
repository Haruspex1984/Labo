package tests;

import java.util.Scanner;

public class ControleurActivity {

    Scanner scan = new Scanner(System.in);
    private Activity model;
    private VueActivite vue;

    ControleurActivity(VueActivite vue, Activity model) {
        this.model = model;
        this.vue = vue;
    }

}

