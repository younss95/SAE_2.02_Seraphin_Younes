package vue;

import controleur.Controleur;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.ApprentiOrdonnateur;
import modele.ExceptionApprentiOrdonnateur;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Une classe représentant le conteneur VBox racine de l'interface utilisateur.
 */
public class VBoxRoot extends VBox implements ConstantesCanvas {
    /** champ de type ApprentiOrdonnateur qui donne les informations de l'apprenti */
    private static ApprentiOrdonnateur apprenti;

    /** champ de type Controleur qui donne les informations sur le controleur */
    private static Controleur controleur;

    /** champ de type VBoxCanvas  */
    private static VBoxCanvas canvas;


    public VBoxRoot() {
//      instanciation des champs apprenti et controleur
        apprenti = new ApprentiOrdonnateur();
        controleur = new Controleur();

//        la barre des menus
        MenuBar menuBar = new MenuBar();
        this.getChildren().add(menuBar);
        VBox.setMargin(menuBar, new Insets(9));

//        Le menu des scénarios
        Menu menuScenario = new Menu(INTITULE_MENU_SCENARIOS);
        menuBar.getMenus().add(menuScenario);

//        Les items du menu scénario
        File [] scenarios = new File("data").listFiles();
        for (int i = 0; i < scenarios.length; i++) {
            MenuItem menuItem = new MenuItem(scenarios[i].getName());
            menuItem.setUserData(scenarios[i]);
            menuItem.setOnAction(controleur);
            menuScenario.getItems().add(menuItem);
        }

        try {
            canvas = new VBoxCanvas();
        } catch (FileNotFoundException | ExceptionApprentiOrdonnateur e) {
            throw new RuntimeException(e);
        }
        this.getChildren().add(canvas);
    }

    
    /** accesseur qui retourne les informations de l'apprenti*/
    public static ApprentiOrdonnateur getApprenti() {
        return apprenti;
    }

    /**
     * Retourne l'instance actuelle du controleur.
     *
     * @return l'instance du controleur
     */
    public static Controleur getControleur() {
        return controleur;
    }

    /**
     * Retourne l'instance actuelle du la classe VBoxCanvas.
     *
     * @return l'instance de VBoxCanvas
     */
    public static VBoxCanvas getCanvas() {
        return canvas;
    }
}
