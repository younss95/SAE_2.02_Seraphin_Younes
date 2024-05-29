package controleur;

import algorithme.AlgoTri;
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

public class Controleur implements EventHandler, ConstantesCanvas {
    @Override
    public void handle(Event event){
        if(event.getSource() instanceof MenuItem) {
            Object userData = ((MenuItem)event.getSource()).getUserData();
            if (userData instanceof File) {
                File fichierScenario = (File) userData;
                System.out.println(fichierScenario.getName());
                File scenario = fichierScenario;
                Collection<Temple> temples = LectureScenario.lecture(fichierScenario);
//                System.out.println(temples);
                VBoxRoot.getApprenti().setTemples(temples);
                VBoxRoot.getCanvas().setTemples(temples);
                System.out.println(VBoxRoot.getApprenti());
                VBoxRoot.getCanvas().updateNbPas();
                VBoxRoot.getApprenti().setPositionApprenti(new Position(0,0));
                VBoxRoot.getCanvas().updateApprenti();
//                System.out.println(VBoxRoot.getApprenti().getListTemples());
            }
        }

//        if(event.getSource() instanceof Button){
//            Button bouton = (Button) event.getSource();
//            if(bouton.getText().equals("Echanger cristal")){
//                Color coulCristalApp = VBoxRoot.getApprenti().getCoulCristal(), varTmpApp = VBoxRoot.getApprenti().getCoulCristal();
//                Position posiApprenti = ApprentiOrdonnateur.getPositionApprenti();
//                Temple templeApprenti = null;
//                for (Temple temple : VBoxRoot.getApprenti().getListTemples()) {
//                    if (temple.getPosiTemple().equals(posiApprenti)) {
//                        templeApprenti = temple;
//                        break;
//                    }
//                }
////                ne fonctionne pas, il faut acceder a la valeur et non à l'adresse mémoir où est stockée l'info
//                assert templeApprenti != null;
//                Color coulCristalTemple = COULEUR_CRISTAL[templeApprenti.getCoulCristal()];
//                System.out.println(coulCristalApp);
//                System.out.println(coulCristalTemple);
//                coulCristalApp = coulCristalTemple;
//                coulCristalTemple = varTmpApp;
//                System.out.println(coulCristalApp);
//                System.out.println(coulCristalTemple);
//
//                System.out.println("Cristal echange");
//
//
//            }
//        }

//        Object userData = ();
        if (event.getSource() instanceof Button bouton) {
            if (bouton.getText().equals("Échanger Cristal")) {

                // Récupérer l'apprenti et sa couleur de cristal actuelle
                ApprentiOrdonnateur apprenti = VBoxRoot.getApprenti();
                Cristal cristalApp = apprenti.getCristal();
                Cristal cristalAppTmps = apprenti.getCristal();
                Position posiApprenti = ApprentiOrdonnateur.getPositionApprenti();

                // Trouver le temple où se trouve l'apprenti
                Temple templeApprenti = null;
                for (Temple temple : apprenti.getListTemples()) {
                    if (temple.getPosiTemple().equals(posiApprenti)) {
                        templeApprenti = temple;
//                        break;
                    }
                }

                // S'assurer que le temple a été trouvé
                if (templeApprenti == null) {
                    System.out.println("Temple non trouvé à la position de l'apprenti.");
                    return;
                }

                // Récupérer la couleur du cristal du temple
                Cristal cristalTemple = templeApprenti.getCristal();

                // Afficher les couleurs avant l'échange
                System.out.println("Avant l'echange :");
                System.out.println("Couleur Cristal Apprenti : " + COULEUR_CRISTAL[cristalApp.getCoulCristal()]);
                System.out.println("Couleur Cristal Temple : " + COULEUR_CRISTAL[cristalTemple.getCoulCristal()]);

                // Échanger les couleurs
                int tempCouleur = cristalApp.getCoulCristal();
                cristalApp.setCoulCristal(cristalTemple.getCoulCristal());
                cristalTemple.setCoulCristal(tempCouleur);

                // Afficher les couleurs après l'échange
                System.out.println("Apres l'echange :");
                System.out.println("Couleur Cristal Apprenti : " + COULEUR_CRISTAL[cristalApp.getCoulCristal()]);
                System.out.println("Couleur Cristal Temple : " + COULEUR_CRISTAL[cristalTemple.getCoulCristal()]);

                System.out.println("Cristal echange");
                VBoxRoot.getCanvas().updateTemple(templeApprenti.getPosiTemple(), cristalTemple);
            }
            if (bouton.getText().equals("Algo Tri")) {
                AlgoTri algoTri = new AlgoTri();
            }
        }

    }
//    private int findColorIndex(Color color) {
//        for (int i = 0; i < COULEUR_CRISTAL.length; i++) {
//            if (COULEUR_CRISTAL[i].equals(color)) {
//                return i;
//            }
//        }
//        return -1; // ou lever une exception si la couleur n'est pas trouvée
//    }
}
