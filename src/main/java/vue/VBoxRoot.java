package vue;

import Controleur.Controleur;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import modele.ApprentiOrdonnateur;
import modele.ExceptionApprentiOrdonnateur;
import modele.Temple;

import java.io.File;
import java.io.FileNotFoundException;


public class VBoxRoot extends VBox implements ConstantesCanvas {
    private static ApprentiOrdonnateur apprenti;
    private static Controleur controleur;
    private static VBoxCanvas canvas;

    public VBoxRoot() {
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

    public static ApprentiOrdonnateur getApprenti() {
        return apprenti;
    }

    public static Controleur getControleur() {
        return controleur;
    }
    public static VBoxCanvas getCanvas() {
        return canvas;
    }
}
