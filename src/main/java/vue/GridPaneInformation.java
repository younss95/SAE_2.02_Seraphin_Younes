package vue;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class GridPaneInformation extends GridPane implements ConstantesCanvas {

    private Label cristalApprenti;
    private Label cristalTemple;

    private Rectangle couleurTemple;

    private Rectangle couleurApprenti;

    private Button boutonCristal;

    public GridPaneInformation () {
        this.setPadding(new Insets(5));
        this.setHgap(5);
        this.setVgap(5);
        this.setGridLinesVisible(false);



        cristalApprenti = new Label("L'apprenti Ordonnateur porte aucun cristal");
        couleurApprenti = new Rectangle(18,18, Color.WHITE);

        cristalTemple = new Label("L'apprenti Ordonnateur n'est pas sur un temple");
        couleurTemple = new Rectangle(20, 20, Color.WHITE);
        this.add(cristalApprenti,0,0,1,1);
        this.add(couleurApprenti,1,0,1,1);

        this.add(cristalTemple,0,1,1,1);
        this.add(couleurTemple,1,1,1,1);


        boutonCristal = new Button("Echanger cristal");
        boutonCristal.setUserData("echange");
        boutonCristal.setOnAction(VBoxRoot.getControleur());

        this.add(boutonCristal,1,3,1,1);

    }
    public void dessinerLabelTemple(int parCouleurTemple) {
        if (cristalTemple.getText().contains(("apprenti")) || couleurTemple.getFill() != COULEUR_TEMPLE[parCouleurTemple]) {
            cristalTemple.setText("La couleur du cristal sur le temple est");
            couleurTemple.setFill(COULEUR_TEMPLE[parCouleurTemple]);
        }
    }

    public void reinitialiserLabelTemple() {
        if (cristalTemple.getText().contains(("couleur"))) {
            cristalTemple.setText("L'apprenti Ordonnateur n'est pas sur un temple");
            couleurTemple.setFill(Color.WHITE);
        }
    }
}

