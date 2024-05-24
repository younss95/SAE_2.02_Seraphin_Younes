package modele;

public class Temple{
    private Position posiTemple;
    private int coulTemple;
    private static Cristal cristal;

    public Temple(Position parPosition, Integer parCoulTemple, Cristal parCristal) {
        posiTemple = parPosition;
        coulTemple = parCoulTemple;
        cristal = parCristal;
    }

    public static Cristal getCristal() {
        return cristal;
    }

    public Position getPosiTemple() {
        return posiTemple;
    }

    public int getCoulTemple() {
        return coulTemple;
    }

    public void setCristal(Cristal parCristal) {
        cristal = parCristal;
    }

    public String toString() {
        return "{Posi : " + posiTemple + " ; CoulTemple : " + coulTemple + " ; Cristal : " + cristal + "}";
    }
}
