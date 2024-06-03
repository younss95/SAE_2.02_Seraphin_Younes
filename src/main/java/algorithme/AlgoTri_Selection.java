package algorithme;

import javafx.scene.canvas.Canvas;
import modele.ApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import vue.VBoxCanvas;
import vue.VBoxRoot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AlgoTri_Selection {

    private ApprentiOrdonnateur apprenti;
    private Collection<Position> ordreVisite;


    public AlgoTri_Selection() {
        System.out.println("Algo tri -> constructeur");
        apprenti = VBoxRoot.getApprenti();
        VBoxCanvas canvas = VBoxRoot.getCanvas();
        Collection<Temple> temples = VBoxRoot.getApprenti().getListTemples();
        Position posiApprenti = apprenti.getPositionApprenti();
        ordreVisite = new ArrayList<>();
        Collection<Temple> recherchePremier = new ArrayList<>(temples);

        // Trouver le temple avec la couleur de cristal la plus basse
        Temple templeMin = recherchePremier.stream().min(Comparator.comparingInt(Temple::getCoulTemple)).orElse(null); // à detailler

        // Parcourir les temples pour les trier
        while (!recherchePremier.isEmpty()) {
            Temple prochainTemple = null;
            int minCouleur = Integer.MAX_VALUE;

            // Trouver le prochain temple avec la couleur de cristal la plus basse parmi les temples non triés
            for (Temple temple : recherchePremier) {
                if (temple.getCoulTemple() < minCouleur) {
                    minCouleur = temple.getCoulTemple();
                    prochainTemple = temple;
                }
            }
            // Supprimer le temple trié de la liste des temples restants
            ordreVisite.add(prochainTemple.getPosiTemple());
            recherchePremier.remove(prochainTemple);
        }
        // Retourner au premier temple visité pour déposer le dernier cristal

        ordreVisite.add(templeMin.getPosiTemple());
        System.out.println(ordreVisite);
    }

    public Collection<Position> getOrdreVisite() {
        return ordreVisite;
    }
}
