package modele;

import javafx.scene.paint.Color;

/** CLASSE POUR LE CRISTAL */
public class Cristal {

//    private static Position posiCristal;
    private static int coulCristal;

    public Cristal(Position parPosition, Integer parCoulCristal){
//        posiCristal = parPosition;
        coulCristal = parCoulCristal;
    }

//    public static Position getPosiCristal() {
//        return posiCristal;
//    }

    public static int getCoulCristal() {
        return coulCristal;
    }

    /** setteur pour définir la couleur du cristal */
    public void setCoulCristal(int parCoulCristal) {
        coulCristal = parCoulCristal;
    }

//    public void setPosiCristal(Position parPosiCristal) {
//        posiCristal = parPosiCristal;
//    }
}
