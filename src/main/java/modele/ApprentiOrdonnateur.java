package modele;

import javafx.scene.paint.Color;
import vue.ConstantesCanvas;

import java.util.ArrayList;
import java.util.Collection;

public class ApprentiOrdonnateur implements ConstantesCanvas {
    private static Position positionApprenti;
    private Collection<Temple> listTemples = new ArrayList<>();
    private Cristal cristal;

    public ApprentiOrdonnateur(){
        positionApprenti = new Position((LARGEUR_CANVAS/CARRE)/2, (HAUTEUR_CANVAS/CARRE)/2);
        cristal = new Cristal(0);
    }

//    public void echange() {
//
//    }


//    Les trucs
    public void setTemples(Collection<Temple> temples) {
        listTemples = temples;
    }

    public static void setPositionApprenti(Position parPosition) {
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
        return "La position de l'apprenti : " + positionApprenti + " " + listTemples;
    }

    public Cristal getCristal() {
        return cristal;
    }

    public void setCoulCristal(Integer parCoulCristal) {
        cristal.setCoulCristal(parCoulCristal);
    }

    public void echangeCristal() {
        Temple templeApprenti = null;
        for (Temple temple : this.getListTemples()) {
            if (temple.getPosiTemple().equals(positionApprenti)) {
                templeApprenti = temple;
//                        break;
            }
        }

        // S'assurer que le temple a été trouvé
        if (templeApprenti == null) {
            System.out.println("Temple non trouvé à la position de l'apprenti.");
            return;
        }

        // Récupérer la couleur du cristal du temple
        Cristal cristalTemple = templeApprenti.getCristal();

        // Afficher les couleurs avant l'échange
        System.out.println("Avant l'echange :");
        System.out.println("Couleur Cristal Apprenti : " + COULEUR_CRISTAL[cristal.getCoulCristal()]);
        System.out.println("Couleur Cristal Temple : " + COULEUR_CRISTAL[cristalTemple.getCoulCristal()]);

        // Échanger les couleurs
        int tempCouleur = cristal.getCoulCristal();
        cristal.setCoulCristal(cristalTemple.getCoulCristal());
        cristalTemple.setCoulCristal(tempCouleur);

        // Afficher les couleurs après l'échange
        System.out.println("Apres l'echange :");
        System.out.println("Couleur Cristal Apprenti : " + COULEUR_CRISTAL[cristal.getCoulCristal()]);
        System.out.println("Couleur Cristal Temple : " + COULEUR_CRISTAL[cristalTemple.getCoulCristal()]);

        System.out.println("Cristal echange");
    }
}
