package modele;

import java.io.File;
import java.io.FileNotFoundException;
<<<<<<< HEAD
import java.util.*;

public class Temples implements Comparable<Position> {
    private TreeMap<Position, TreeSet<Integer>> chMapAttributs;

    public Temples() throws FileNotFoundException, ExceptionApprentiOrdonnateur {
        chMapAttributs = new TreeMap<>();

        Scanner scanner = new Scanner(new File("data" + File.separator + "scenario.txt")).useDelimiter(",");
//        Mettre try et catch
=======
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Temples {
    private TreeMap<Position, TreeSet<Integer>> chMapAttributs;

    public Temples() throws FileNotFoundException {
        chMapAttributs = new TreeMap<>();
        Scanner scanner = new Scanner(new File("data" + File.separator + "scenario.txt")).useDelimiter(",");

>>>>>>> 677b1ab20fc4b8b1d9056acaed9fe87a3958e944
        while(scanner.hasNext()) {
            int abscisse = scanner.nextInt();
            int ordonne = scanner.nextInt();
            int coulTemp = scanner.nextInt();
            int coulCrist = scanner.nextInt();

            TreeSet<Integer> setAttributs = new TreeSet<>();
<<<<<<< HEAD
=======

>>>>>>> 677b1ab20fc4b8b1d9056acaed9fe87a3958e944
            if (coulTemp > 0 && coulCrist > 0) {
                setAttributs.add(coulTemp);
                setAttributs.add(coulCrist);
            }
<<<<<<< HEAD
            System.out.println(chMapAttributs);


            if (abscisse > 0 && ordonne > 0) {
                Position posiTemp = new Position(abscisse, ordonne);
                System.out.println(posiTemp);
                System.out.println(setAttributs);
                chMapAttributs.put(posiTemp,setAttributs);
//                System.out.println("1234");
                System.out.println(chMapAttributs);
            }

        }

    }
    public TreeMap<Position, TreeSet<Integer>> getMapAttributs() {
        return chMapAttributs;
    }

    @Override
    public int compareTo(Position o) {
        return 0;
    }
=======

            if (abscisse > 0 && ordonne > 0) {
                Position posiTemp = new Position(abscisse, ordonne);
                chMapAttributs.put(posiTemp,setAttributs);
            }
        }

    }
>>>>>>> 677b1ab20fc4b8b1d9056acaed9fe87a3958e944
}
