package modele;

import vue.ConstantesCanvas;

import java.util.ArrayList;
import java.util.Collection;

public class ApprentiOrdonnateur implements ConstantesCanvas {
    private Position positionApprenti;
    private Collection<Temple> listTemples = new ArrayList<>();

    public ApprentiOrdonnateur(){
        positionApprenti = new Position(LARGEUR_CANVAS/2, HAUTEUR_CANVAS/2);
    }

    public void setTemples(Collection<Temple> temples) {
        listTemples = temples;
    }
    public void setPositionApprenti(Position parPosition) {
        positionApprenti = parPosition;
    }

    public String toString(){
        return positionApprenti + " " + listTemples;
    }
}
