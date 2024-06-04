package algorithme;

import modele.Position;
import modele.Temple;

import java.util.ArrayList;
import java.util.List;

public class AlgoHeuristique {

    private List<Position> ordreVisite;
    private List<Temple> listTemples;
    private Position positionApprenti;

    public AlgoHeuristique(List<Temple> listeTemples) {
        listTemples = listeTemples;
        ordreVisite = new ArrayList<>();
        positionApprenti = new Position(16, 16); // Position initiale de l'apprenti
        trierTemplesParCouleur();
        heuristique();
    }

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

    private Temple trouverTempleLePlusProche(Position position, List<Integer> templesVisites) {
        Temple templeLePlusProche = null;
        int distanceMinimale = Integer.MAX_VALUE;

        for (int i = 0; i < listTemples.size(); i++) {
            if (!templesVisites.contains(i)) {
                Temple temple = listTemples.get(i);
                int distanceActuelle = distance(position, temple.getPosiTemple());
                if (distanceActuelle < distanceMinimale) {
                    distanceMinimale = distanceActuelle;
                    templeLePlusProche = temple;
                }
            }
        }

        return templeLePlusProche;
    }

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
    private int distance(Position p1, Position p2) {
        return Math.abs(p1.getAbscisse() - p2.getAbscisse()) + Math.abs(p1.getOrdonnee() - p2.getOrdonnee());
    }

    public List<Position> getOrdreVisite() {
        return ordreVisite;
    }
}