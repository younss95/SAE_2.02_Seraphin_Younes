package modele;

import javafx.scene.paint.Color;
import vue.ConstantesCanvas;

import java.util.ArrayList;
import java.util.Collection;

public class ApprentiOrdonnateur implements ConstantesCanvas {
    private static Position positionApprenti;
    private Collection<Temple> listTemples = new ArrayList<>();
    private static Color coulCrsital;

    public ApprentiOrdonnateur(){
        positionApprenti = new Position((LARGEUR_CANVAS/CARRE)/2, (HAUTEUR_CANVAS/CARRE)/2);
        coulCrsital = null;
    }

    public void echange() {

    }


//    Les trucs
    public void setTemples(Collection<Temple> temples) {
        listTemples = temples;
    }

    public void setPositionApprenti(Position parPosition) {
        positionApprenti = parPosition;
    }
//    Les accesseurs
    public static Position getPositionApprenti() {
        return positionApprenti;
    }
    public Collection<Temple> getListTemples() {
        return listTemples;
    }

    public Color getCoulCristal() {
        return coulCrsital;
    }

    public String toString(){
        return "La position de l'apprenti : " + positionApprenti + " " + listTemples;
    }
}
