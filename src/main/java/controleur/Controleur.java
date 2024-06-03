package controleur;

import algorithme.AlgoHeuristique;
import algorithme.AlgoTri;
import algorithme.AlgoTri_Selection;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import modele.*;
import vue.ConstantesCanvas;
import vue.LectureScenario;
import vue.VBoxRoot;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class Controleur implements EventHandler, ConstantesCanvas {
    @Override
    public void handle(Event event) {
        if (event.getSource() instanceof MenuItem) {
            Object userData = ((MenuItem) event.getSource()).getUserData();
            if (userData instanceof File) {
                File fichierScenario = (File) userData;
                System.out.println(fichierScenario.getName());
                Collection<Temple> temples = LectureScenario.lecture(fichierScenario);
                VBoxRoot.getApprenti().setTemples(temples);
                VBoxRoot.getCanvas().setTemples(temples);
                System.out.println(VBoxRoot.getApprenti());
                VBoxRoot.getCanvas().updateNbPas();
//                VBoxRoot.getApprenti().setPositionApprenti(new Position((LARGEUR_CANVAS/CARRE)/2, (HAUTEUR_CANVAS/CARRE)/2));
                VBoxRoot.getCanvas().updateApprenti(new Position((LARGEUR_CANVAS / CARRE) / 2, (HAUTEUR_CANVAS / CARRE) / 2));
            }
        }

        if (event.getSource() instanceof Button) {

            Button bouton = (Button) event.getSource();

            // Vérifiez si le bouton cliqué est "Algo Tri"
            if (bouton.getText().equals("Algo Tri")) {
                System.out.println("bouton algo cliqué");
                new AlgoTri();
            }

            if (bouton.getText().equals("Tri Selection")) {
                System.out.println("bouton tri selection cliqué");
                AlgoTri_Selection triSelection = new AlgoTri_Selection();
                List<Position> ordreVisite = (List<Position>) triSelection.getOrdreVisite();
                ApprentiOrdonnateur apprenti = VBoxRoot.getApprenti();
                Position posiApprenti = apprenti.getPositionApprenti();
                System.out.println(posiApprenti);
                VBoxRoot.getCanvas().deplacement(ordreVisite);

            }
            if (bouton.getText().equals("Algo Heuristique")) {
                System.out.println("bouton algo heuristique cliqué");
                new AlgoHeuristique();
            }


            if (bouton.getText().equals("Échanger Cristal")) {
                System.out.println("bouton echange cristal cliqué");

                // Code pour échanger le cristal
                ApprentiOrdonnateur apprentiOrdo = VBoxRoot.getApprenti();
                System.out.println(apprentiOrdo.getPositionApprenti());
                apprentiOrdo.echangeCristal();

//                VBoxRoot.getCanvas().updateTemple(templeApprenti.getPosiTemple(), cristalTemple);
                }
            }
        }
    }


