package algorithme;

import modele.ApprentiOrdonnateur;
import modele.Cristal;
import modele.Position;
import modele.Temple;
import vue.VBoxRoot;

import java.util.Collection;

public class AlgoTri {

    private ApprentiOrdonnateur apprenti;

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
                        System.out.println("Apprenti va a la position " + currentTemple.getPosiTemple());
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











