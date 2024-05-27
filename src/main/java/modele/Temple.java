package modele;

/** CLASSE POUR LE TEMPLE*/
public class Temple{
    /** champ pour la position du temple */
    private Position posiTemple;

    /** champ pour la couleur du temple*/
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

    /** accesseur qui retourne la position du temple */
    public Position getPosiTemple() {
        return posiTemple;
    }

    /** accesseur qui retourne la couleur du temple */
    public int getCoulTemple() {
        return coulTemple;
    }

    /** setteur qui defini le cristal */
    public void setCristal(Cristal parCristal) {
        cristal = parCristal;
    }

    public String toString() {
        return "{Posi : " + posiTemple + " ; CoulTemple : " + coulTemple + " ; Cristal : " + cristal + "}";
    }
}
