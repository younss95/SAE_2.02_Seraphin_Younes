//package algorithme;
//import modele.ApprentiOrdonnateur;
//import modele.Position;
//import modele.Temple;
//import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
//import vue.VBoxCanvas;
//import vue.VBoxRoot;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
//public class AlgoTri_Selection {
//    List<Position> listePosiTemple;
//    List<Integer> listeCristaux;
////    List<Integer> listeParcours;
//    List<Position> ordreVisite;
//    VBoxCanvas vue;
//
//
//    public AlgoTri_Selection(List<Temple> listeTemple){
//        //l'apprenti se trouve en 16;16
//        ArrayList<Temple> listeTempleTriee = new ArrayList<>();
//        listePosiTemple = new ArrayList<Position>();
//        listeCristaux = new ArrayList<Integer>();
////        listeParcours = new ArrayList<>();
//        ordreVisite = new ArrayList<>();
//
//        for(int i = 0; i < listeTemple.size(); i++){
//            int j=0;
//            while (listeTemple.get(j).getCoulTemple()!=i+1){
//                j++;
//            }
//            listeTempleTriee.add(listeTemple.get(j));
//        }
//
//        System.out.println(listeTempleTriee);
//
//        // instancie les listes
//        for (int i = 0; i < listeTempleTriee.size(); i++){
//            listePosiTemple.add(listeTempleTriee.get(i).getPosiTemple());
//            listeCristaux.add(listeTempleTriee.get(i).getCristal().getCoulCristal());
//        }
//
//        //l'algo
//        for (int i=0; i<listeCristaux.size()-1;i++){
//            int index = i;
//            for (int j = i + 1; j < listeCristaux.size(); j++)
//            {
//                if (listeCristaux.get(j) < listeCristaux.get(index)){
//                    index = j;
//                }
//            }
//            if (listeTempleTriee.get(index) != listeTempleTriee.get(i)){
////                listeParcours.add(index+1);
////                listeParcours.add(i+1);
////                listeParcours.add(index+1);
//                ordreVisite.add(listeTempleTriee.get(index).getPosiTemple());
//                ordreVisite.add(listeTempleTriee.get(i).getPosiTemple());
//                ordreVisite.add(listeTempleTriee.get(index).getPosiTemple());
//
//
//                int min = listeCristaux.get(index);
//
//                listeCristaux.set(index,listeCristaux.get(i));
//                listeCristaux.set(i,min);
//            }
//
//        }
////        ordreVisite.add(ordreVisite.get(ordreVisite.size()-1));
//
////        System.out.println("parcours : "+listeParcours);
//        System.out.println("parcours : "+ordreVisite);
//
////        VBoxCanvas.deplacementEchange(listeParcoursPos);
//
//    }
//
//    public List<Position> getOrdreVisite() {
//        return ordreVisite;
//    }
//
//}


package algorithme;

import modele.ApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import vue.VBoxCanvas;
import vue.VBoxRoot;
import java.util.ArrayList;
import java.util.List;

public class AlgoTri_Selection {

    private List<Position> listePosiTemple;
    private List<Integer> listeCristaux;
    private List<Position> ordreVisite;
    private VBoxCanvas vue;
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

    public List<Position> getOrdreVisite() {
        return ordreVisite;
    }
}