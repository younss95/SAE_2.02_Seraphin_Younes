package algorithme;

import modele.Position;
import modele.Temple;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe implémente un algorithme heuristique pour visiter une liste de temples.
 * L'algorithme choisit le temple le plus proche de la position actuelle de l'apprenti
 * et visite les temples en fonction de la couleur de leurs cristaux.
 */
public class AlgoHeuristique {
    /**
     * Liste ordonnée des positions visitées par l'apprenti.
     */
    private List<Position> ordreVisite;
    /**
     * Liste des temples à visiter.
     */
    private List<Temple> listTemples;
    /**
     * Position actuelle de l'apprenti.
     */
    private Position positionApprenti;

    /**
     * Constructeur de la classe AlgoHeuristique.
     * @param listeTemples Liste des temples à visiter.
     */
    public AlgoHeuristique(List<Temple> listeTemples) {
        listTemples = listeTemples;
        ordreVisite = new ArrayList<>();
        positionApprenti = new Position(16, 16); // Position initiale de l'apprenti
        trierTemplesParCouleur();
        heuristique();
    }

    /**
     * Trie la liste des temples par couleur.
     */
    private void trierTemplesParCouleur() {
        int n = listTemples.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (listTemples.get(j).getCoulTemple() > listTemples.get(j + 1).getCoulTemple()) {
                    // Échange les temples
                    Temple temp = listTemples.get(j);
                    listTemples.set(j, listTemples.get(j + 1));
                    listTemples.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Implémente l'algorithme heuristique pour visiter les temples.
     */
    private void heuristique() {
        List<Integer> templesVisites = new ArrayList<>();

        // Commence avec un cristal transparent (on suppose couleur 0)
        int couleurCristal = 0;

        // Trouver et visiter le temple le plus proche
        Temple premierTemple = trouverTempleLePlusProche(positionApprenti, templesVisites);
        if (premierTemple != null) {
            // Ajouter la position du premier temple visité à l'ordre des visites
            ordreVisite.add(premierTemple.getPosiTemple());
            // Mettre à jour la position de l'apprenti
            positionApprenti = premierTemple.getPosiTemple();
            // Mettre à jour la couleur du cristal de l'apprenti
            couleurCristal = premierTemple.getCristal().getCoulCristal();
            // Ajouter le premier temple visité à la liste des temples visités
            templesVisites.add(listTemples.indexOf(premierTemple));
        }

        // Boucle pour parcourir les temples et échanger les cristaux
        for (int i = 0; i < listTemples.size(); i++) {
            Temple prochainTemple = trouverTempleParCouleur(couleurCristal, templesVisites);
            if (prochainTemple != null) {
                // Ajouter la position du prochain temple à l'ordre des visites
                ordreVisite.add(prochainTemple.getPosiTemple());
                // Mettre à jour la position de l'apprenti
                positionApprenti = prochainTemple.getPosiTemple();
                // Mettre à jour la couleur du cristal de l'apprenti
                couleurCristal = prochainTemple.getCristal().getCoulCristal();
                // Ajouter le temple visité à la liste des temples visités
                templesVisites.add(listTemples.indexOf(prochainTemple));
            } else {
                break; // Si aucun temple n'est trouvé, sortir de la boucle
            }
        }

        // Retourner au premier temple visité pour déposer le dernier cristal
        if (!ordreVisite.isEmpty()) {
            ordreVisite.add(ordreVisite.get(0));
        }

        System.out.println("Parcours : " + ordreVisite);
    }

    /**
     * Trouve le temple le plus proche de la position spécifiée.
     * @param position Position actuelle de l'apprenti.
     * @param templesVisites Liste des indices des temples déjà visités.
     * @return Le temple le plus proche de la position spécifiée.
     */
    private Temple trouverTempleLePlusProche(Position position, List<Integer> templesVisites) {
        Temple templeLePlusProche = null;
        int distanceMinimale = Integer.MAX_VALUE;

        for (int i = 0; i < listTemples.size(); i++) {
            if (!templesVisites.contains(i)) {
                Temple temple = listTemples.get(i);
                int distanceActuelle = distance(position, temple.getPosiTemple());
                if (distanceActuelle < distanceMinimale) {
                    if (temple.getCoulTemple() != temple.getCristal().getCoulCristal()) {
                        distanceMinimale = distanceActuelle;
                        templeLePlusProche = temple;
                    }
                }
            }
        }

        return templeLePlusProche;
    }

    /**
     * Trouve le prochain temple à visiter en fonction de la couleur du cristal.
     * @param couleurCristal Couleur du cristal actuel de l'apprenti.
     * @param templesVisites Liste des indices des temples déjà visités.
     * @return Le prochain temple à visiter, null s'il n'y en a pas.
     */
    private Temple trouverTempleParCouleur(int couleurCristal, List<Integer> templesVisites) {
        for (int i = 0; i < listTemples.size(); i++) {
            if (!templesVisites.contains(i)) {
                Temple temple = listTemples.get(i);
                if (temple.getCoulTemple() == couleurCristal) {
                    return temple;
                }
            }
        }
        return null;
    }

    /**
     * Calcule la distance entre deux positions.
     * @param p1 Première position.
     * @param p2 Deuxième position.
     * @return La distance entre les deux positions.
     */
    private int distance(Position p1, Position p2) {
        return Math.abs(p1.getAbscisse() - p2.getAbscisse()) + Math.abs(p1.getOrdonnee() - p2.getOrdonnee());
    }

    /**
     * Renvoie la liste ordonnée des positions visitées par l'apprenti.
     * @return La liste ordonnée des positions visitées.
     */
    public List<Position> getOrdreVisite() {
        return ordreVisite;
    }
}