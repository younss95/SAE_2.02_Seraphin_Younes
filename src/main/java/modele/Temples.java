package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Temples implements Comparable{
    private TreeMap<Position, TreeSet<Integer>> chMapAttributs;

    public Temples() throws FileNotFoundException {
        chMapAttributs = new TreeMap<>();
        Scanner scanner = new Scanner(new File("data" + File.separator + "scenario.txt")).useDelimiter(",");

        while(scanner.hasNext()) {
            int abscisse;
            int ordonne;
            int coulTemp;
            int coulCrist;

            String abscisseStr = scanner.next();
            String ordonneStr = scanner.next();
            String coulTempStr = scanner.next();
            String coulCristStr = scanner.next();

            if (abscisseStr.contains("\n")) {
                abscisse = Integer.parseInt(abscisseStr.replace("\n", ""));
            }

//            System.out.println(chMapAttributs);

            TreeSet<Integer> setAttributs = new TreeSet<>();

            if (coulTemp > 0 && coulCrist > 0) {
                setAttributs.add(coulTemp);
                setAttributs.add(coulCrist);
            }
            System.out.println(setAttributs);

            if (abscisse > 0 && ordonne > 0) {
                Position posiTemp = new Position(abscisse, ordonne);
                System.out.println(posiTemp);
                chMapAttributs.put(posiTemp,setAttributs);
            }
        }

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public TreeMap<Position, TreeSet<Integer>> getMapAttributs() {
        return chMapAttributs;
    }
}
