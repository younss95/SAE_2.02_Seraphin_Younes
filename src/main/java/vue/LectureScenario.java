package vue;

import modele.Position;
import modele.Temple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LectureScenario implements ConstantesCanvas{
    /**
     * la méthode de lecture prend en parametre un fichier contenant un scénario
     * et retourne une collcetion de données contenant les temples à réaligner
     */

    public static Collection<Temple> lecture (File fichierScenario){
        Collection<Temple> templesDuScenario = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(fichierScenario);
            Temple temple;
            while(scanner.hasNext()){
                int posX = scanner.nextInt() + LARGEUR_CANVAS/(2*CARRE);
                int posY = scanner.nextInt() + HAUTEUR_CANVAS/(2*CARRE);

                int couleur = scanner.nextInt();
                int cristal = scanner.nextInt();
                temple = new Temple(new Position(posX, posY), couleur, cristal);
                templesDuScenario.add(temple);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        return templesDuScenario;
    }

}
