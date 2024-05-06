package modele;

import vue.ConstantesCanvas;

import java.util.ArrayList;
import java.util.Collection;

public class ApprentiOrdonnateur implements ConstantesCanvas {
    private static Position positionApprenti;
    private Collection<Temple> listTemples = new ArrayList<>();

    public ApprentiOrdonnateur(){
        positionApprenti = new Position((LARGEUR_CANVAS/CARRE)/2, (HAUTEUR_CANVAS/CARRE)/2);
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

    public String toString(){
        return positionApprenti + " " + listTemples;
    }
}
