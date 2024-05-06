package vue;

import Controleur.Controleur;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modele.ApprentiOrdonnateur;
import modele.ExceptionApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VBoxRoot extends VBox implements ConstantesCanvas {
    private static ApprentiOrdonnateur apprenti;
    private static Controleur controleur;
    private static VBoxCanva canva;

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
            canva = new VBoxCanva();
        } catch (FileNotFoundException | ExceptionApprentiOrdonnateur e) {
            throw new RuntimeException(e);
        }
    }

    public static ApprentiOrdonnateur getApprenti() {
        return apprenti;
    }


}
