package modele;

import javafx.scene.paint.Color;
import vue.ConstantesCanvas;

import java.util.ArrayList;
import java.util.Collection;

/**
 * La classe `ApprentiOrdonnateur` représente un apprenti dans un jeu ou une simulation
 * qui peut se déplacer et interagir avec des temples et un cristal.
 */
public class ApprentiOrdonnateur implements ConstantesCanvas {
    /** Position de l'apprenti */
    private Position positionApprenti;

    /** Collection des temples */
    private Collection<Temple> listTemples = new ArrayList<>();

    /** Cristal de l'apprenti */
    private Cristal cristal;

    /**
     * Constructeur par défaut qui initialise la position de l'apprenti et son cristal.
     * La position initiale de l'apprenti est au centre du canvas.
     */
    public ApprentiOrdonnateur(){
        positionApprenti = new Position((LARGEUR_CANVAS/CARRE)/2, (HAUTEUR_CANVAS/CARRE)/2);
        cristal = new Cristal(0);
    }

    /**
     * Définit la liste des temples.
     *
     * @param temples une collection de temples à affecter.
     */
    public void setTemples(Collection<Temple> temples) {
        listTemples = temples;
    }

    /**
     * Définit la position de l'apprenti.
     *
     * @param parPosition la nouvelle position de l'apprenti.
     */
    public void setPositionApprenti(Position parPosition) {
        positionApprenti = parPosition;
    }

    /**
     * Obtient la position actuelle de l'apprenti.
     *
     * @return la position actuelle de l'apprenti.
     */
//    public Position getPositionApprenti() {
//        return positionApprenti;
//    }

    public Position getPositionApprenti() {
        return positionApprenti;
    }

    /**
     * Obtient la liste des temples.
     *
     * @return une collection des temples.
     */
    public Collection<Temple> getListTemples() {
        return listTemples;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'apprenti,
     * incluant sa position et la liste des temples.
     *
     * @return une chaîne de caractères représentant l'apprenti.
     */
    public String toString(){
        return "La position de l'apprenti : " + positionApprenti + " " + listTemples;
    }

    /**
     * Obtient le cristal de l'apprenti.
     *
     * @return le cristal de l'apprenti.
     */
    public Cristal getCristal() {
        return cristal;
    }

    /**
     * Définit la couleur du cristal de l'apprenti.
     *
     * @param parCoulCristal la nouvelle couleur du cristal.
     */
    public void setCoulCristal(Integer parCoulCristal) {
        cristal.setCoulCristal(parCoulCristal);
    }

    /**
     * Échange le cristal de l'apprenti avec celui du temple où il se trouve actuellement.
     *
     * Cette méthode vérifie d'abord si l'apprenti se trouve dans un temple. Si c'est le cas,
     * elle échange les couleurs des cristaux de l'apprenti et du temple, puis affiche les couleurs
     * avant et après l'échange.
     */
    public void echangeCristal() {
        Temple templeApprenti = null;
        for (Temple temple : listTemples) {
            if (temple.getPosiTemple().equals(positionApprenti)) {
                templeApprenti = temple;
                break;
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
        System.out.println("------------------------------------------------------------");
        System.out.println(" ");
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

