package algorithme;

import modele.ApprentiOrdonnateur;
import modele.Cristal;
import modele.Position;
import modele.Temple;
import vue.VBoxRoot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * La classe AlgoTri implémente un algorithme de tri pour l'apprenti dans les temples.
 * L'apprenti se déplace entre les temples et échange les cristaux en fonction de leur couleur.
 */
public class AlgoTri {

    private ApprentiOrdonnateur apprenti;

    /**
     * Construit une instance de la classe AlgoTri.
     * Initialise l'apprenti et trie les temples pour gérer les échanges de cristaux.
     */
    public AlgoTri() {
        System.out.println("Algo tri -> constructeur");
        apprenti = VBoxRoot.getApprenti();
        Collection<Temple> temples = VBoxRoot.getApprenti().getListTemples();
        Position posiApprenti = apprenti.getPositionApprenti();
        List<Temple> ordreVisite = new ArrayList<>();

        // Collecte des temples ayant des cristaux incorrects
        for (Temple templeTmp : temples) {
            if (!templeTmp.getCristal().equalsCoul(templeTmp.getCoulTemple())) {
                ordreVisite.add(templeTmp);
            }
        }

        if (ordreVisite.isEmpty()) {
            System.out.println("Tous les cristaux sont déjà correctement placés.");
            return;
        }

        // Sauvegarde de la position du premier temple visité
        Temple premierTemple = ordreVisite.get(0);

        // Parcours des temples et échange des cristaux
        for (Temple temple : ordreVisite) {
            try {
                System.out.println("Apprenti va à la position " + temple.getPosiTemple());
                while (!posiApprenti.equals(temple.getPosiTemple())) {
                    posiApprenti.deplacementUneCase(temple.getPosiTemple());
                }
                apprenti.echangeCristal();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Retour au premier temple visité pour déposer le dernier cristal
        try {
            System.out.println("Apprenti retourne au premier temple visité à la position " + premierTemple.getPosiTemple());
            while (!posiApprenti.equals(premierTemple.getPosiTemple())) {
                posiApprenti.deplacementUneCase(premierTemple.getPosiTemple());
            }
            apprenti.echangeCristal();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
