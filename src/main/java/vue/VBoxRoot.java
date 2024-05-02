package vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modele.ExceptionApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VBoxRoot extends VBox implements ConstantesCanvas{
    private Label labelNombreDePas;
    private Canvas canvasCarte;
    private GraphicsContext graphicsContext2D;
    private Position positionApprenti;

//    private Image imagePersonnage;
    private ArrayList<Temple> listTemple = new ArrayList<>();

    public VBoxRoot() throws FileNotFoundException, ExceptionApprentiOrdonnateur {
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
        int numCol = -15;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARRE; i < LARGEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numCol), i+CARRE/3, CARRE/2);
            numCol++;
        }
//        les numuméros de ligne
        int numLigne = -15;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARRE; i < HAUTEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARRE/3, i+CARRE/2);
            numLigne++;
        }

//        Lecture fichier
        Scanner scanner = new Scanner(new File("data" + File.separator + "scenario.txt")).useDelimiter(",");
        while(scanner.hasNext()) {
            int abscisse = scanner.nextInt();
            int ordonne = scanner.nextInt();
            int coulTemp = scanner.nextInt();
            int coulCrist = scanner.nextInt();

            if (coulTemp >= 0 && coulCrist >= 0) {
                Position posiTemple = new Position(abscisse, ordonne);
                Temple temple = new Temple(posiTemple, coulTemp, coulCrist);
                System.out.println(temple);
                listTemple.add(temple);
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
        System.out.println(listTemple);

//        Placement des temples sur la map
        for (Temple temple :listTemple) {
            graphicsContext2D.setFill(COULEUR_TEMPLE[temple.getCoulTemple()]);
            graphicsContext2D.fillRect(temple.getPosiTemple().getAbscisse()*CARRE+16, temple.getPosiTemple().getAbscisse()*CARRE+16, CARRE-2, CARRE-2);
        }
        System.out.println(listTemple);

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
//                ordoImp.setImage(null);

//                Effacer le personnage de la case
                graphicsContext2D.clearRect(positionApprenti.getAbscisse() * CARRE+2, positionApprenti.getOrdonnee() * CARRE+2, CARRE-3, CARRE-3);

//                redessiner le temple sur la position effacée
                for (Temple temple : listTemple) {
                    if (positionApprenti.equals(temple.getPosiTemple())) {
                        graphicsContext2D.setFill(COULEUR_TEMPLE[temple.getCoulTemple()]);
                        graphicsContext2D.fillRect(temple.getPosiTemple().getAbscisse()*CARRE+16, temple.getPosiTemple().getAbscisse()*CARRE+16, CARRE-2, CARRE-2);
                        break;
                    }
                }
//                System.out.println(listTemple);

//                deplacement du personnage
                Image imagePersonnage = new Image("F:\\SAE\\SAE 2.02 Exploration algorithmique\\TP-SAE\\Image\\ApprentiImage.png");
                positionApprenti.deplacementUneCase(positionCliquee);
                ImageView en_mouv = new ImageView(imagePersonnage);

//                dessin du perso sur la nouvelle position
                graphicsContext2D.drawImage(en_mouv.getImage(), positionApprenti.getAbscisse() * CARRE + 1 + CARRE / 8, positionApprenti.getOrdonnee() * CARRE + CARRE / 4, LARGEUR_OVALE, HAUTEUR_OVALE);
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
