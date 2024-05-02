package modele;

public class Temple{
    private Position posiTemple;
    private int coulTemple;
    private int coulCristal;

    public Temple(Position parPosition, Integer parCoulTemple, Integer parCoulCristal) {
        posiTemple = parPosition;
        coulTemple = parCoulTemple;
        coulCristal = parCoulCristal;
    }

    public Position getPosiTemple() {
        return posiTemple;
    }

    public int getCoulTemple() {
        return coulTemple;
    }

    public int getCoulCristal() {
        return coulCristal;
    }

    public String toString() {
        return "{Posi : " + posiTemple + " ; CoulTemple : " + coulTemple + " ; CoulCristal : " + coulCristal + "}";
    }
}
