package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ApprentiOrdonnateurApplication extends Application {
    public void start(Stage stage) {
        VBox root = new VBoxRoot();
        Scene scene = new Scene(root, 1000, 920);
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
