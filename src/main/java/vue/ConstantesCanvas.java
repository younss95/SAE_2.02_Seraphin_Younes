package vue;

import javafx.scene.paint.Color;


/**  intferace qui déclare les valeurs/constantes de notre jeu
 * tel que les dimensions ou la couleur */
public interface ConstantesCanvas {
    String INTITULE_MENU_SCENARIOS = "Scénario";
    Color COULEUR_GRILLE = Color.BLACK;
    Color COULEUR_APPRENTI = Color.RED;
    Color [] COULEUR_TEMPLE = {Color.TRANSPARENT, Color.GRAY, Color.BROWN, Color.PINK, Color.ORANGE, Color.VIOLET, Color.BLUE, Color.YELLOW, Color.GREEN, Color.PURPLE, Color.CYAN};
    Color [] COULEUR_CRISTAL = {Color.TRANSPARENT, Color.GRAY, Color.BROWN, Color.PINK, Color.ORANGE, Color.VIOLET, Color.BLUE, Color.YELLOW, Color.GREEN, Color.PURPLE, Color.CYAN};
    int LARGEUR_CANVAS = 800;
    int HAUTEUR_CANVAS = 800;
    int CARRE = 25;
    int LARGEUR_IMAGE_APP = 25;
    int HAUTEUR_IMAGE_APP = 25;


}
