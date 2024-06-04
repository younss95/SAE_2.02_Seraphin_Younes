package algorithme;
import modele.ApprentiOrdonnateur;
import modele.Position;
import modele.Temple;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;
import vue.VBoxCanvas;
import vue.VBoxRoot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlgoTri_Selection {
    List<Position> listePosTemple;
    List<Position> listePos;
    List<Integer> listeCristaux;
    List<Integer> listeParcours;
    List<Position> ordreVisite;
    VBoxCanvas vue;


    public AlgoTri_Selection(List<Temple> listeTemple){
        //l'apprenti se trouve en 16;16
        ArrayList<Temple> listeTempleTriée = new ArrayList<>();
        listePos = new ArrayList<Position>();
        listeCristaux = new ArrayList<Integer>();
        listeParcours = new ArrayList<>();
        ordreVisite = new ArrayList<>();

        for(int i = 0; i < listeTemple.size(); i++){
            System.out.println(listeTemple.get(i));
            System.out.println(listeTemple.get(i).getCoulTemple());
            int j=0;
            while (listeTemple.get(j).getCoulTemple()!=i+1){
                j++;
            }
            listeTempleTriée.add(listeTemple.get(j));
        }

        System.out.println(listeTempleTriée);

        // instancie les listes
        for (int i = 0; i < listeTempleTriée.size(); i++){
            listePos.add(listeTempleTriée.get(i).getPosiTemple());
            listeCristaux.add(listeTempleTriée.get(i).getCristal().getCoulCristal());
        }
        listePosTemple = listePos;

        //l'algo
        for (int i=0; i<listeCristaux.size()-1;i++){
            int index = i;
            for (int j = i + 1; j < listeCristaux.size(); j++)
            {
                if (listeCristaux.get(j) < listeCristaux.get(index)){
                    index = j;
                }
            }
            if (listeTempleTriée.get(index) != listeTempleTriée.get(i)){
                listeParcours.add(index+1);
                listeParcours.add(i+1);
                listeParcours.add(index+1);
                ordreVisite.add(listeTempleTriée.get(index).getPosiTemple());
                ordreVisite.add(listeTempleTriée.get(i).getPosiTemple());
                ordreVisite.add(listeTempleTriée.get(index).getPosiTemple());


                int min = listeCristaux.get(index);

                listeCristaux.set(index,listeCristaux.get(i));
                listeCristaux.set(i,min);
            }

        }
//        ordreVisite.add(ordreVisite.get(ordreVisite.size()-1));

        System.out.println("parcours : "+listeParcours);
        System.out.println("parcours : "+ordreVisite);

//        VBoxCanvas.deplacementEchange(listeParcoursPos);

    }

    public List<Position> getOrdreVisite() {
        return ordreVisite;
    }

}