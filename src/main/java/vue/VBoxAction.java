package vue;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;

public class VBoxAction extends VBox {

    public VBoxAction() {

        // Définir la hauteur de l'espace en haut
        Region topSpace = new Region();
        topSpace.setPrefHeight(50); // espace correspondant au menu

        // Initialiser les composants de la VBox
        Label labelNombrePas = VBoxRoot.getCanvas().getLabelNombreDePas();
        Label labelEchangeCrsit = new Label("Échangez un cristal");
        Button boutonEchange = new Button("Échanger Cristal");
        boutonEchange.setUserData("Échanger Cristal");

        // Ajouter un écouteur d'événement pour le bouton
        boutonEchange.setOnAction(VBoxRoot.getControleur());

        // Ajouter les composants à la VBox
        this.getChildren().addAll(topSpace, labelNombrePas, labelEchangeCrsit, boutonEchange);

        // Ajouter du padding et de l'espacement pour l'esthétique
        this.setPadding(new Insets(10));
        this.setSpacing(10);
    }
}
