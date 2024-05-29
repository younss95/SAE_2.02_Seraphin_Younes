package modele;

/** CLASSE POUR LE TEMPLE*/
public class Temple{
    /** champ pour la position du temple */
    private Position posiTemple;

    /** champ pour la couleur du temple*/
    private int coulTemple;

    /** champ pour le cristal */
    private Cristal cristal;

    /**
     * constructeur qui initialise le temple en lui donnant ses caracteristiques
     * sa position, sa couleur et le cristal
     * @param parPosition
     * @param parCoulTemple
     * @param parCristal
     */
    public Temple(Position parPosition, Integer parCoulTemple, Cristal parCristal) {
        posiTemple = parPosition;
        coulTemple = parCoulTemple;
        cristal = parCristal;
    }


    /** accesseur qui retourne le cristal */
    public Cristal getCristal() {
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

    /** setteur qui defini la couleur du cristal */
    public void setCoulCristal(Integer parCoulCristal) {
        cristal.setCoulCristal(parCoulCristal);
     }


    /** la méthode equals compare la couleur du temple (this) avec la couleur en paramètre*/
    public boolean equalsCoul(int parCouleur) {
        return this.getCoulTemple() == parCouleur;
    }


    /** méthode toString qui donne comme information sur le temple : sa position, sa couleur et son cristal */
    public String toString() {
        return "{Posi : " + posiTemple + " ; CoulTemple : " + coulTemple + " ; Cristal : " + cristal + "}";
    }
}
