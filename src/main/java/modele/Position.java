package modele;

/** CLASSE QUI DONNE LA POSITION DE L'APPRENTI */
public class Position implements Comparable {
    /** champ pour les nombres de pas de l'apprenti */
    private static int nombreDePas = 0;

    /** champ abscisse*/
    private int abscisse;

    /** champ ordonnee*/
    private int ordonnee;

    /** crée une instance de la classe Position en donnant une abcsisse et une ordonnée*/
    public Position(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    /** accesseur qui retourne le nombre de pas*/
    public static int getNombreDePas() {
        return nombreDePas;
    }


/**  setteur qui definit le nombre de pas initial que la joueur a fait */
    public static void setNombreDePasInit() {
        nombreDePas = 0;
    }

    /**
     * la méthode deplacementUneCase déplace la position this d'une case
     * pour la rapprocher de celle du paramètre parPosition
     * elle incrémente le champ static nombreDePas
     * @param parPosition : la position vers laquelle this se rapproche
     */
    public void deplacementUneCase(Position parPosition) {
        nombreDePas++;
        if (parPosition.abscisse == 0 || parPosition.ordonnee == 0) {
            System.out.println("deplacement impossible");
        }
        else {
            if (this.abscisse > parPosition.abscisse) {
                this.abscisse -= 1;
                return;
            }

            if (this.abscisse < parPosition.abscisse) {
                this.abscisse += 1;
                return;
            }
            if (this.ordonnee > parPosition.ordonnee) {
                this.ordonnee -= 1;
                return;
            }
            if (this.ordonnee < parPosition.ordonnee) {
                this.ordonnee += 1;
                return;
            }
        }
    }

    /**
     * la methode equals retourne
     * @param parPosition
     * @return
     */
    public boolean equals(Position parPosition) {
        return this.abscisse == parPosition.abscisse && this.ordonnee == parPosition.ordonnee;
    }

    /**
     * Compare cet objet `Position` avec l'objet spécifié pour l'ordre.
     *
     * @param o l'objet à comparer.
     * @return un entier négatif, zéro ou un entier positif selon que cette `Position`
     * est moins que, égale à, ou plus grande que la `Position` spécifiée.
     */
    public int compareTo(Object o) {
        Position parPosition = (Position) o;
        if (this.ordonnee-parPosition.ordonnee != 0) {
            return this.ordonnee-parPosition.ordonnee;
        }
        else if (this.abscisse-parPosition.abscisse != 0) {
            return this.abscisse-parPosition.abscisse;
        }
        else {
            return 0;
        }
    }

    /** accesseur qui retourne la position en abscisse */
    public int getAbscisse() {
        return abscisse;
    }

    /** accesseur qui retourn la position en ordonnée.
     */
    public int getOrdonnee() {
        return ordonnee;
    }

    /** setteur qui defini la position en abscisse  */
    public void setAbscisse(int parAbscisse){abscisse = parAbscisse;}

    /** setteur qui defini la position en ordonnee  */
    public void setOrdonnee(int parOrdonnee){ordonnee = parOrdonnee;}


    /**
     * la methode toString renvoie une chaine de caractere qui decrit la position de l'apprenti
     * avec son abcsisse et son ordonnée
     * @return les coordonnées de l'apprenti
     */
    public String toString() {
        String abscisseStr = String.valueOf(abscisse-16);
        String ordonneeStr = String.valueOf(ordonnee-16);

        return "(" + abscisseStr + ", " + ordonneeStr + ")";
    }
}
