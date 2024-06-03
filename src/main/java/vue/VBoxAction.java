package vue;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;

/** LA CLASSE VBOXACTION PERMET DE VOIR LES INDICATIONS DE LA PARTIE
 * elle hérite de VBox*/
public class VBoxAction extends VBox {

    public VBoxAction() {

        // Définir la hauteur de l'espace en haut
        Region topSpace = new Region();
        topSpace.setPrefHeight(50); // espace correspondant au menu

        // Initialiser les composants de la VBox
        Label labelNombrePas = VBoxRoot.getCanvas().getLabelNombreDePas();
        Button boutonEchange = new Button("Échanger Cristal");
        boutonEchange.setOnAction(VBoxRoot.getControleur());

        // Ajouter les composants à la VBox
        this.getChildren().addAll(topSpace, labelNombrePas, boutonEchange);

//        bouton d'algorithme de tri
        Button boutonTri = new Button("Algo Tri");
        boutonTri.setOnAction(VBoxRoot.getControleur());
        this.getChildren().add(boutonTri);

//        bouton d'algorithme de tri par Selection
        Button boutonTriSel = new Button("Tri Selection");
        boutonTriSel.setOnAction(VBoxRoot.getControleur());
        this.getChildren().add(boutonTriSel);

//        bouton d'algorithme de tri par Selection
        Button boutonTriHeuristique = new Button("Algo Heuristique");
        boutonTriHeuristique.setOnAction(VBoxRoot.getControleur());
        this.getChildren().add(boutonTriHeuristique);

        // Ajouter du padding et de l'espacement pour l'esthétique
        this.setPadding(new Insets(10));
        this.setSpacing(10);
    }
}
