package algorithme;

import modele.ApprentiOrdonnateur;
import modele.Cristal;
import modele.Position;
import modele.Temple;
import vue.VBoxRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * La classe AlgoHeuristique implémente un algorithme heuristique pour un apprenti dans un temple.
 * L'apprenti se déplace entre les temples pour échanger des cristaux en fonction de la distance
 * et des conditions spécifiques.
 */
public class AlgoHeuristique {

    private ApprentiOrdonnateur apprenti;
    private List<Position> ordreVisite;

    /**
     * Construit une instance de la classe AlgoHeuristique.
     * Initialise l'apprenti et traite chaque temple pour gérer les échanges de cristaux en utilisant une heuristique basée sur la distance.
     */
    public AlgoHeuristique() {
        System.out.println("Algo heuristique -> constructeur");
        apprenti = VBoxRoot.getApprenti();
        ordreVisite = new ArrayList<>();
        Position posiApprenti = apprenti.getPositionApprenti();
        List<Temple> temples = new ArrayList<>(apprenti.getListTemples());
//        System.out.println(temples);

        // Trier les temples par distance à l'apprenti (du plus proche au plus éloigné)
        temples.sort(Comparator.comparingDouble(t -> posiApprenti.distance(t.getPosiTemple())));
//        System.out.println(temples);

        // Variable pour suivre si l'apprenti a déjà pris un cristal
        boolean porteCristal = false;

        // Parcourir les temples et échanger les cristaux
        for (Temple temple : temples) {
            // Déplacer l'apprenti vers le temple
            ordreVisite.add(temple.getPosiTemple());
            // Vérifier si la couleur du cristal du temple correspond à celle du temple
            if (!temple.getCristal().equalsCoul(temple.getCoulTemple())) {
                // Si ce n'est pas le cas, prendre le cristal du temple
                if (!porteCristal) {
                    porteCristal = true;
                } else {
                    // Sinon, échanger les cristaux
                }
            }
        }

        // Retourner au premier temple visité pour déposer le dernier cristal
        if (porteCristal) {
            try {
                Temple premierTemple = temples.get(0);
                System.out.println("Apprenti retourne au premier temple visité à la position " + premierTemple.getPosiTemple());
                ordreVisite.add(premierTemple.getPosiTemple());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
