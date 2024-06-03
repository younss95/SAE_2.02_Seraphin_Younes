package algorithme;

import modele.ApprentiOrdonnateur;
import modele.Cristal;
import modele.Position;
import modele.Temple;
import vue.VBoxRoot;

import java.util.Collection;

/**
 * La classe AlgoTri implémente l'algorithme de tri pour un apprenti dans un temple.
 * L'apprenti se déplace entre les temples pour échanger des cristaux en fonction de conditions spécifiques.
 */
public class AlgoTri {

    private ApprentiOrdonnateur apprenti;

    /**
     * Construit une instance de la classe AlgoTri.
     * Initialise l'apprenti et traite chaque temple pour gérer les échanges de cristaux.
     */
    public AlgoTri() {
        System.out.println("Algo tri -> constructeur");
        apprenti = VBoxRoot.getApprenti();
        Collection<Temple> temples = VBoxRoot.getApprenti().getListTemples();

        Position posiApprenti = ApprentiOrdonnateur.getPositionApprenti();

        for (Temple currentTemple : temples) {
            Cristal cristalTemple = currentTemple.getCristal();
            posiApprenti.deplacementUneCase(currentTemple.getPosiTemple());
            System.out.println(posiApprenti);
            if (cristalTemple.equalsCoul(currentTemple.getCoulTemple()) && !currentTemple.equalsCoul(currentTemple.getCoulTemple())) {
                try {
                    System.out.println("Apprenti va à la position " + currentTemple.getPosiTemple());
                    while (!posiApprenti.equals(currentTemple.getPosiTemple())) {
                        posiApprenti.deplacementUneCase(currentTemple.getPosiTemple());
                    }
                    apprenti.echangeCristal();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}










