package Controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import modele.ApprentiOrdonnateur;
import modele.ExceptionApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import vue.ConstantesCanvas;
import vue.LectureScenario;
import vue.VBoxRoot;

import java.io.File;
import java.io.FileNotFoundException;
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
                VBoxRoot.getApprenti().setTemples(temples);
                VBoxRoot.getCanvas().setTemples(temples);
                System.out.println(VBoxRoot.getApprenti());
                System.out.println(VBoxRoot.getApprenti().getListTemples());
            }
        }
//        Object userData = ()
        if(event.getSource() instanceof Button){
            Button bouton = (Button) event.getSource();
            if(bouton.getText().equals("Echanger cristal")){
                Color coulCristalApp = VBoxRoot.getApprenti().getCoulCristal(), varTmpApp = VBoxRoot.getApprenti().getCoulCristal();
                Position posiApprenti = ApprentiOrdonnateur.getPositionApprenti();
                Temple templeApprenti = null;
                for (Temple temple : VBoxRoot.getApprenti().getListTemples()) {
                    if (temple.getPosiTemple().equals(posiApprenti)) {
                        templeApprenti = temple;
                        break;
                    }
                }
//                ne fonctionne pas, il faut acceder a la valeur et non à l'adresse mémoir où est stockée l'info
                assert templeApprenti != null;
                Color coulCristalTemple = COULEUR_CRISTAL[templeApprenti.getCoulCristal()];
                System.out.println(coulCristalApp);
                System.out.println(coulCristalTemple);
                coulCristalApp = coulCristalTemple;
                coulCristalTemple = varTmpApp;
                System.out.println(coulCristalApp);
                System.out.println(coulCristalTemple);

                System.out.println("Cristal echange");


            }
        }

    }
}
