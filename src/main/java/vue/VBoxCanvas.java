package vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modele.*;

import java.io.FileNotFoundException;
import java.util.*;


/** LA CLASSE VBOXCANVAS QUI HERITE DE VBOX ET IMPLEMENTE L'INTERFACE CONSTANTESCANVAS
 * */
public class VBoxCanvas extends VBox implements ConstantesCanvas {

    /**
     * ce champ de type label qui affiche le nombres de pas
     */
    private Label labelNombreDePas;

    /**
     * ce champ de type canvas permet de creer la grille du jeu
     */
    private Canvas canvasCarte;

    /**
     * ce champ de type graphicsContext permet de créer les elements 2D comme les carrés pour les grilles du jeu
     */
    private GraphicsContext graphicsContext2D;

    /**
     * ce champ de type Position donne la position de l'apprenti
     */
    private Position positionApprenti;

    /**
     * ApprentiOrdonnateur associé à ce VBoxCanvas.
     */
    private ApprentiOrdonnateur apprenti = VBoxRoot.getApprenti();


    /**
     * ce champ de type Collection est une liste qui donne les temples du jeu
     */
    private Collection<Temple> listTemple = new ArrayList<>();

    public VBoxCanvas() throws FileNotFoundException, ExceptionApprentiOrdonnateur {

//        l'étiquette qui affiche le nombre de pas
        labelNombreDePas = new Label("Nombre de pas : 0");

//        création de l'image du perso

        Image imagePersonnage = new Image("F:\\SAE\\SAE 2.02 Exploration algorithmique\\ApprentiOrdonnateur\\SAE_2.02_Seraphin_Younes\\Image\\Sticker_Magicien.PNG");
        ImageView imageMag = new ImageView(imagePersonnage);
        imageMag.setFitWidth(LARGEUR_IMAGE_APP);
        imageMag.setFitHeight(HAUTEUR_IMAGE_APP);

//        le Canvas et son contexte graphique
        canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        graphicsContext2D = canvasCarte.getGraphicsContext2D();

//        les carrés
        graphicsContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < LARGEUR_CANVAS; i += CARRE) {
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }
//        les numéros de colonne
        int numCol = -15;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARRE; i < LARGEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numCol), i + CARRE / 3, CARRE / 2);
            numCol++;
        }
//        les numuméros de ligne
        int numLigne = -15;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARRE; i < HAUTEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARRE / 3, i + CARRE / 2);
            numLigne++;
        }
//        System.out.println(listTemple);
//        Placement des temples sur la map


//        System.out.println(listTemple);

//        Position apprenti
        positionApprenti = apprenti.getPositionApprenti();
//        imagePersonnage = new Image("F:\SAE\SAE 2.02 Exploration algorithmique\ApprentiOrdonnateur\SAE_2.02_Seraphin_Younes\Image\Sticker_Magicien.PNG");
//        ImageView imageMag = new ImageView(imagePersonnage);
        graphicsContext2D.drawImage(imageMag.getImage(), positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, LARGEUR_IMAGE_APP, HAUTEUR_IMAGE_APP);


//        affichage d'un rond pour représenter l'apprenti
//        graphicsContext2D.setFill(COULEUR_APPRENTI);
//        graphicsContext2D.fillOval(positionApprenti.getAbscisse()*CARRE + 1 + CARRE/8,
//                positionApprenti.getOrdonnee()*CARRE + CARRE/4, LARGEUR_IMAGE_APP, HAUTEUR_IMAGE_APP);

        canvasCarte.setOnMouseClicked(event -> {
            int abscisse = (int) event.getX() / CARRE;
            int ordonnee = (int) event.getY() / CARRE;
            Position positionCliquee = new Position(abscisse, ordonnee);
//            colorie la case selectionnée
            graphicsContext2D.setStroke(Color.RED);
            graphicsContext2D.strokeRect(abscisse * CARRE, ordonnee * CARRE, CARRE, CARRE);
            System.out.println(positionCliquee);
            deplacementAvecTimer(positionCliquee, positionApprenti);
        });

//        ajout des composants graphiques à la racine (this)
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));


//          ajout de l'image du personnage
//        this.getChildren().add(imageView);
//        VBox.setMargin(imageView, new Insets(positionApprenti.getAbscisse()* CARRE + CARRE / 8,
//                positionApprenti.getOrdonnee()*CARRE + CARRE / 4, 0, 0));


    }
//        Déplacement de l'apprenti

    /**
     * La méthode déplace l'apprenti vers la position de la case saisie en paramètre
     *
     * @param positionCliquee  Position : position obtenu en cliquant sur une case
     * @param positionApprenti Position : position de l'apprenti
     */
    private void deplacementAvecTimer(Position positionCliquee, Position positionApprenti) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int absCliquee = positionCliquee.getAbscisse();
                int ordCliquee = positionCliquee.getOrdonnee();

                // Vérifier si la position cliquée est sur les numéros de ligne ou de colonne
                if (absCliquee == 0 || ordCliquee == 0) {
                    System.out.println("deplacement impossible");
                    graphicsContext2D.setStroke(Color.BLACK);
                    graphicsContext2D.strokeRect(positionCliquee.getAbscisse() * CARRE, positionCliquee.getOrdonnee() * CARRE, CARRE, CARRE);

                    // Ignorer le déplacement
                    timer.cancel();
                    return;
                }

                // Effacer le personnage de la case
                graphicsContext2D.clearRect(positionApprenti.getAbscisse() * CARRE + 2, positionApprenti.getOrdonnee() * CARRE + 2, CARRE - 3, CARRE - 3);
                graphicsContext2D.setStroke(Color.BLACK);
                graphicsContext2D.strokeRect(positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, CARRE, CARRE);

                // Redessiner le temple sur la position effacée
                for (Temple temple : listTemple) {
                    if (positionApprenti.equals(temple.getPosiTemple())) {
                        graphicsContext2D.setFill(COULEUR_TEMPLE[temple.getCoulTemple()]);
                        graphicsContext2D.fillRect(temple.getPosiTemple().getAbscisse() * CARRE + 1, temple.getPosiTemple().getOrdonnee() * CARRE + 1, CARRE - 2, CARRE - 2);

                        //  Redessiner le cristal du temple
                        graphicsContext2D.setFill(COULEUR_CRISTAL[temple.getCristal().getCoulCristal()]);
                        graphicsContext2D.fillOval(temple.getPosiTemple().getAbscisse() * CARRE + 4, temple.getPosiTemple().getOrdonnee() * CARRE + 4, CARRE - 8, CARRE - 8);
                        break;
                    }
                }

                // Déplacement du personnage
                Image imagePersonnage = new Image("F:\\SAE\\SAE 2.02 Exploration algorithmique\\ApprentiOrdonnateur\\SAE_2.02_Seraphin_Younes\\Image\\Sticker_Magicien.PNG");
                positionApprenti.deplacementUneCase(positionCliquee);
                apprenti.setPositionApprenti(positionCliquee);
                ImageView imageMag = new ImageView(imagePersonnage);

                // Dessin du personnage sur la nouvelle position
                graphicsContext2D.drawImage(imageMag.getImage(), positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, LARGEUR_IMAGE_APP, HAUTEUR_IMAGE_APP);

                // Si le déplacement est valide et que le personnage a atteint la position cliquée,
                // arrêtez le timer et mettez à jour le nombre de pas.
                if (positionApprenti.equals(positionCliquee)) {
                    timer.cancel();
                    Platform.runLater(() -> {
                        labelNombreDePas.setText("Nombre de pas : " + Position.getNombreDePas());
                    });
                }
            }
        };

        // Planifier le timerTask pour exécution
        timer.scheduleAtFixedRate(timerTask, 1000, 200);
    }

    public void deplacement(List<Position> listPositions) {
        int[] i = {0};
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                // Effacement de l'apprenti de la case à positionCourante
                graphicsContext2D.clearRect(positionApprenti.getAbscisse() * CARRE + 2, positionApprenti.getOrdonnee() * CARRE + 2, CARRE - 3, CARRE - 3);
                graphicsContext2D.setStroke(Color.BLACK);
                graphicsContext2D.strokeRect(positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, CARRE, CARRE);

                // Redessiner le temple sur la position effacée
                for (Temple temple : listTemple) {
                    if (positionApprenti.equals(temple.getPosiTemple())) {
                        graphicsContext2D.setFill(COULEUR_TEMPLE[temple.getCoulTemple()]);
                        graphicsContext2D.fillRect(temple.getPosiTemple().getAbscisse() * CARRE + 1, temple.getPosiTemple().getOrdonnee() * CARRE + 1, CARRE - 2, CARRE - 2);

                        //  Redessiner le cristal du temple
                        graphicsContext2D.setFill(COULEUR_CRISTAL[temple.getCristal().getCoulCristal()]);
                        graphicsContext2D.fillOval(temple.getPosiTemple().getAbscisse() * CARRE + 4, temple.getPosiTemple().getOrdonnee() * CARRE + 4, CARRE - 8, CARRE - 8);
                        break;
                    }
                }

                // Déplacement du personnage
                Image imagePersonnage = new Image("F:\\SAE\\SAE 2.02 Exploration algorithmique\\ApprentiOrdonnateur\\SAE_2.02_Seraphin_Younes\\Image\\Sticker_Magicien.PNG");
                positionApprenti.deplacementUneCase(listPositions.get(i[0]));
                apprenti.setPositionApprenti(listPositions.get(i[0]));
                ImageView imageMag = new ImageView(imagePersonnage);

                // Réafficher l'apprenti sur la case à positionCible
                 graphicsContext2D.drawImage(imageMag.getImage(), positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, LARGEUR_IMAGE_APP, HAUTEUR_IMAGE_APP);


                Platform.runLater(() -> {
                    labelNombreDePas.setText("Nombre de pas : " + Position.getNombreDePas());
                });

                // Si l'apprenti est arrivé à la position suivante, on incrémente i
                if (positionApprenti.equals(listPositions.get(i[0]))) {
                    VBoxRoot.getApprenti().echangeCristal();
                    i[0]++;

                    // Si l'apprenti est arrivé à la dernière position, on arrête le timer
                    if (i[0] >= listPositions.size()) {
                        timer.cancel();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 300);
    }

    /**
     * Met à jour la liste des temples en supprimant les temples existants et en affichant les nouveaux temples sur le canvas.
     *
     * @param temples la nouvelle collection de temples à afficher.
     */
    public void setTemples(Collection<Temple> temples) {
//        supression des temples pré-existant (lors chgmt de scénario)
        for (Temple temple : listTemple) {
            graphicsContext2D.clearRect(temple.getPosiTemple().getAbscisse() * CARRE + 2, temple.getPosiTemple().getOrdonnee() * CARRE + 2, CARRE - 3, CARRE - 3);
            if (positionApprenti.equals(temple.getPosiTemple())) {
                Image imagePersonnage = new Image("F:\\SAE\\SAE 2.02 Exploration algorithmique\\ApprentiOrdonnateur\\SAE_2.02_Seraphin_Younes\\Image\\Sticker_Magicien.PNG");
                ImageView imageMag = new ImageView(imagePersonnage);
                graphicsContext2D.drawImage(imageMag.getImage(), positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, LARGEUR_IMAGE_APP, HAUTEUR_IMAGE_APP);
            }
        }
//        affichage des nouveaux temples sur le canvas
        listTemple = temples;
        for (Temple temple : listTemple) {
            graphicsContext2D.setFill(COULEUR_TEMPLE[temple.getCoulTemple()]);
            graphicsContext2D.fillRect(temple.getPosiTemple().getAbscisse() * CARRE + 1, temple.getPosiTemple().getOrdonnee() * CARRE + 1, CARRE - 2, CARRE - 2);
            graphicsContext2D.setFill(COULEUR_CRISTAL[temple.getCristal().getCoulCristal()]);
            graphicsContext2D.fillOval(temple.getPosiTemple().getAbscisse() * CARRE + 4, temple.getPosiTemple().getOrdonnee() * CARRE + 4, CARRE - 8, CARRE - 8);

        }
    }

    /**
     * l'accesseur getLabelNombreDePas permet d'avoir le nombre de pas du joueur
     */
    public Label getLabelNombreDePas() {
        return labelNombreDePas;
    }

    /** met à jour le nombre de pas à chaque mouvements de l'apprenti  */
    public void updateNbPas() {
        Position.setNombreDePasInit();
        labelNombreDePas.setText("Nombre de pas : " + Position.getNombreDePas());
    }

    /** la méthode updateApprenti  affiche la nouvelle position du joueur a chaque déplacements*/
    public void updateApprenti(Position posiCible) {
        graphicsContext2D.clearRect(positionApprenti.getAbscisse() * CARRE + 2, positionApprenti.getOrdonnee() * CARRE + 2, CARRE - 3, CARRE - 3);
        graphicsContext2D.setStroke(Color.BLACK);
        graphicsContext2D.strokeRect(positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, CARRE, CARRE);
        positionApprenti = new Position(posiCible.getAbscisse(), posiCible.getOrdonnee());
        apprenti.setPositionApprenti(posiCible);
        Image imagePersonnage = new Image("F:\\SAE\\SAE 2.02 Exploration algorithmique\\ApprentiOrdonnateur\\SAE_2.02_Seraphin_Younes\\Image\\Sticker_Magicien.PNG");
        ImageView imageMag = new ImageView(imagePersonnage);
        graphicsContext2D.drawImage(imageMag.getImage(), positionApprenti.getAbscisse() * CARRE, positionApprenti.getOrdonnee() * CARRE, LARGEUR_IMAGE_APP, HAUTEUR_IMAGE_APP);
    }
}
