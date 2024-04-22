package vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Position;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.Timer;
import java.util.TimerTask;

public class VBoxRoot extends VBox implements ConstantesCanvas{
    private Label labelNombreDePas;
    private Canvas canvasCarte;
    private GraphicsContext graphicsContext2D;
    private Position positionApprenti;

    public VBoxRoot() {
//        l'étiquette qui affiche le nombre de pas
        labelNombreDePas = new Label("Nombre de pas : 0");

//        le Canvas et son contexte graphique
        canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        graphicsContext2D = canvasCarte.getGraphicsContext2D();

//        les carrés
        graphicsContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < LARGEUR_CANVAS ; i += CARRE) {
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }
//        les numéros de colonne
        int numCol = 0;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARRE; i < LARGEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numCol), i+CARRE/3, CARRE/2);
            numCol++;
        }
//        les numuméros de ligne
        int numLigne = 0;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARRE; i < HAUTEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARRE/3, i+CARRE/2);
            numLigne++;
        }

//        Position apprenti
        positionApprenti = new Position(1, 1);
        graphicsContext2D.setFill(COULEUR_APPRENTI);
        graphicsContext2D.fillOval(positionApprenti.getAbscisse()*CARRE + 1 + CARRE/8,
                positionApprenti.getOrdonnee()*CARRE + CARRE/4, LARGEUR_OVALE, HAUTEUR_OVALE);

        canvasCarte.setOnMouseClicked(event -> {
        int abscisse = (int) event.getX() / CARRE;
        int ordonnee = (int) event.getY() / CARRE;
        Position positionCliquee = new Position(abscisse, ordonnee);
        graphicsContext2D.fillRect(abscisse*CARRE+1, ordonnee*CARRE+1, CARRE-2, CARRE-2);
        System.out.println(positionCliquee);
        deplacementAvecTimer(positionCliquee, positionApprenti);
        });

//        ajout des composants graphiques à la racine (this)
        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));
    }
//        Déplacement de l'apprenti
    /**
     * La méthode déplace l'apprenti vers la position de la case saisie en paramètre
     * @param positionCliquee Position : position obtenu en cliquant sur une case
     * @param positionApprenti Position : position de l'apprenti
     */
    private void deplacementAvecTimer(Position positionCliquee, Position positionApprenti) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                graphicsContext2D.clearRect(positionApprenti.getAbscisse() * CARRE+2, positionApprenti.getOrdonnee() * CARRE+2, CARRE-3, CARRE-3);
                positionApprenti.deplacementUneCase(positionCliquee);
                graphicsContext2D.fillOval(positionApprenti.getAbscisse() * CARRE + 1 + CARRE / 8, positionApprenti.getOrdonnee() * CARRE + CARRE / 4, LARGEUR_OVALE, HAUTEUR_OVALE);
                if (positionApprenti.equals(positionCliquee)) {
                    timer.cancel();
                }

            Platform.runLater(() -> {
                labelNombreDePas.setText("Nombre de pas : " + Position.getNombreDePas());
            });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 200);

    }
}
