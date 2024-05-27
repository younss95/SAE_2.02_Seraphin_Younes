package modele;

import javafx.scene.paint.Color;

/** CLASSE POUR LE CRISTAL */
public class Cristal {

//    private static Position posiCristal;
    /** la couleur du cristal*/
    private int coulCristal;

//    public Cristal(Position parPosition, Integer parCoulCristal){
//        posiCristal = parPosition;
//        coulCristal = parCoulCristal;
//    }

    /** constructeur de la classe qui initialise la couleur du cristal*/
    public Cristal(Integer parCoulCristal){
        coulCristal = parCoulCristal;
    }

//    public static Position getPosiCristal() {
//        return posiCristal;
//    }


    /** accesseur pour obtenir la couleur du cristal */
    public int getCoulCristal() {
        return coulCristal;
    }

    /** setteur pour définir la couleur du cristal */
    public void setCoulCristal(int parCoulCristal) {
        coulCristal = parCoulCristal;
    }

//    public void setPosiCristal(Position parPosiCristal) {
//        posiCristal = parPosiCristal;
//    }

    /** méthode toString qui retourne une représentationn du cristal */
    public String toString() {
        return "Couleur du cristal : " + coulCristal;
    }
}
