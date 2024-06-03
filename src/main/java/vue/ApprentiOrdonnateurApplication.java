package vue;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.ExceptionApprentiOrdonnateur;

import java.io.File;
import java.io.FileNotFoundException;


/** LA CLASSE PERMET DE LANCER L'APPLICATION */
public class ApprentiOrdonnateurApplication extends Application {
    public void start(Stage stage) throws FileNotFoundException, ExceptionApprentiOrdonnateur {

        // Créer deux instances de VBoxRoot
        VBox vRoot = new VBoxRoot();
        VBoxAction vBoxAction = new VBoxAction();

        // Créer une HBox et ajouter les VBox
        HBox hRoot = new HBox();
        hRoot.getChildren().addAll(vRoot, vBoxAction);

        // Ajouter du padding et de l'espacement pour l'esthétique
        hRoot.setPadding(new Insets(10));
        hRoot.setSpacing(10);

        // Créer un ScrollPane et ajouter la HBox
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(hRoot);
        scrollPane.setFitToWidth(true);  // Ajuster la largeur du ScrollPane au contenu
        scrollPane.setFitToHeight(true); // Ajuster la hauteur du ScrollPane au contenu

        // Obtenir la taille de l'écran principal
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = screenBounds.getWidth();
        double screenHeight = screenBounds.getHeight();

        Scene scene = new Scene(scrollPane, screenWidth, screenHeight);
//        File[] fichiersCss = new File("css").listFiles();
//        for (File fichier : fichiersCss) {
//            scene.getStylesheets().add(fichier.toURI().toString());
//        }
        stage.setScene(scene);
        stage.setTitle("GRILLE DU JEU");
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
    }
