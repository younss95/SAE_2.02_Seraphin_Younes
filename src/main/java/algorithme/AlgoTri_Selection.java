package algorithme;

import modele.ApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import vue.VBoxCanvas;
import vue.VBoxRoot;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe implémente un algorithme de tri par sélection pour ordonner la visite des temples en fonction de la couleur de leurs cristaux.
 */
public class AlgoTri_Selection {
    /**
     * Liste des positions des temples.
     */
    private List<Position> listePosiTemple;
    /**
     * Liste des couleurs des cristaux des temples.
     */
    private List<Integer> listeCristaux;
    /**
     * Liste ordonnée des positions visitées par l'apprenti.
     */
    private List<Position> ordreVisite;

    /**
     * Constructeur de la classe AlgoTri_Selection.
     * @param listeTemple Liste des temples à visiter.
     */
    public AlgoTri_Selection(List<Temple> listeTemple) {

        // L'apprenti se trouve en 16;16
        List<Temple> listeTempleTriee = new ArrayList<>();
        listePosiTemple = new ArrayList<>();
        listeCristaux = new ArrayList<>();
        ordreVisite = new ArrayList<>();

        // Trier les temples par leur couleur de temple
        for (int i = 0; i < listeTemple.size(); i++) {
            int j = 0;
            while (listeTemple.get(j).getCoulTemple() != i + 1) {
                j++;
            }
            listeTempleTriee.add(listeTemple.get(j));
        }
        System.out.println(listeTempleTriee);

        // Initialiser les listes de positions et de cristaux
        for (Temple temple : listeTempleTriee) {
            listePosiTemple.add(temple.getPosiTemple());
            listeCristaux.add(temple.getCristal().getCoulCristal());
        }

        // Algorithme de tri par sélection
        for (int i = 0; i < listeCristaux.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < listeCristaux.size(); j++) {
                if (listeCristaux.get(j) < listeCristaux.get(index)) {
                    index = j;
                }
            }

            // Effectuer les échanges nécessaires
            if (index != i) {
                ordreVisite.add(listeTempleTriee.get(index).getPosiTemple());
                ordreVisite.add(listeTempleTriee.get(i).getPosiTemple());
                ordreVisite.add(listeTempleTriee.get(index).getPosiTemple());
                int min = listeCristaux.get(index);
                listeCristaux.set(index, listeCristaux.get(i));
                listeCristaux.set(i, min);
            }
        }
        System.out.println("Parcours : " + ordreVisite);
    }

    /**
     * Renvoie la liste ordonnée des positions visitées par l'apprenti.
     * @return La liste ordonnée des positions visitées.
     */
    public List<Position> getOrdreVisite() {
        return ordreVisite;
    }
}