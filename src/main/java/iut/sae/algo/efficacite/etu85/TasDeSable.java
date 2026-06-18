package iut.sae.algo.efficacite.etu85;

public class TasDeSable {

    /**
     * Fait s'effondrer le bac de sable jusqu'à ce qu'il soit stable.
     * Parcourt toutes les cases avec une seule boucle for en calculant
     * les indices i et j à partir d'un index linéaire k.
     * Complexite O(n2) donc quadratique
     *
     * @param bac le tableau 2 Dimension representant bac de sable
     * @return le bac de sable stable
     */
    public static int[][] effondrer(int[][] bac) {
        int nbLignes   = bac.length;
        int nbColonnes = bac[0].length;
        boolean modif  = true;

        // On répète tant qu'une case a changé lors du dernier passage
        while (modif) {
            modif = false;

            // Parcours linéaire du tableau 2D : évite les deux boucles imbriquées
            for (int k = 0; k < ( nbLignes * nbColonnes); k++) {
                //ici on calcule les indices au lieu de cree une boucle imbriqué
                int i = k / nbColonnes; // on calcule i
                int j = k % nbColonnes; // on calcule j

                // Si la case est instable on l'effondre
                if (estInstable(bac, i, j)) {
                    effondrerCase(bac, i, j);
                    modif = true; // Une case a changé, on refait un passage
                }
            }
        }
        return bac;
    }

    /**
     * Effectue l'effondrement d'une case vers ses voisins.
     * Pour chaque voisin ayant plus d'un grain de moins, on transfère un grain.
     * Les voisins sont parcourus dans l'ordre horaire : haut, droite, bas, gauche.
     * Complexité O(1) donc constante 
     *
     * @param bac le tableau 2D représentant le bac de sable
     * @param ligne ligne de la case à effondrer
     * @param colonne colonne de la case à effondrer
     */
    public static void effondrerCase(int bac[][], int ligne, int colonne) {
        int nbLignes = bac.length;
        int nbColones = bac[0].length;

        // voisin dans l'ordre horaire : haut, droite, bas, gauche
        int[] voisinHaut = { ligne - 1, colonne };
        int[] voisinDroite = { ligne, colonne + 1 };
        int[] voisinBas = { ligne + 1, colonne };
        int[] voisinGauche = { ligne, colonne - 1 };

        int[][] voisins = { voisinHaut, voisinDroite, voisinBas, voisinGauche };

        // Pour chaque voisin valide, on transfère un grain si la différence est > 1
        for (int i = 0; i < voisins.length; i++) {
            int vLigne = voisins[i][0];
            int vColonne = voisins[i][1];

            if (estDansTab(vLigne, vColonne, nbLignes, nbColones)) {
                if (bac[ligne][colonne] - bac[vLigne][vColonne] > 1) {

                    // Ajoute un grain au voisin
                    bac[vLigne][vColonne] = bac[vLigne][vColonne] + 1;

                    // Retire un grain à la case centrale
                    bac[ligne][colonne] = bac[ligne][colonne] - 1;
                }
            }
        }
    }

    /**
     * Vérifie si une position appartient bien au tableau.
     * Permet d'éviter de sortir des limites lors de l'accès aux voisins.
     * Complexité O(1) donc constante
     *
     * @param ligne numéro de ligne à vérifier
     * @param colone numéro de colonne à vérifier
     * @param nbLigne nombre total de ligne
     * @param nbColonnes nombre total de colonne
     * @return true si la position est valide, false sinon
     */
    public static boolean estDansTab(int ligne, int colone, int nbLigne, int nbColonnes) {

        if (ligne < 0 || ligne >= nbLigne) {
            return false;
        }
        if (colone < 0 || colone >= nbColonnes) {
            return false;
        }
        return true;
    }

    /**
     * Détermine si une case est instable.
     * Une case est considérée comme instable si elle possède
     * un voisin ayant plus d'un grain de moins qu'elle.
     *Complexité O(1) donc constante
     *
     * @param bac le bac de sable
     * @param ligne ligne de la case étudiée
     * @param colonne colonne de la case étudiée
     * @return true si la case est instable, false sinon
     */
    public static boolean estInstable(int bac[][], int ligne, int colonne) {
        int nbLignes = bac.length;
        int nbColones = bac[0].length;
        int valeurCase = bac[ligne][colonne];

        // Voisins dans l'ordre : haut, droite, bas, gauche
        int[] voisinHaut = { ligne - 1, colonne };
        int[] voisinDroite = { ligne, colonne + 1 };
        int[] voisinBas = { ligne + 1, colonne };
        int[] voisinGauche = { ligne, colonne - 1 };

        int[][] voisins = { voisinHaut, voisinDroite, voisinBas, voisinGauche };

        // On vérifie chaque voisin : si la différence est > 1 la case est instable
        for (int i = 0; i < voisins.length; i++) {
            int vLigne = voisins[i][0];
            int vColonne = voisins[i][1];

            if (estDansTab(vLigne, vColonne, nbLignes, nbColones)) {
                if (valeurCase - bac[vLigne][vColonne] > 1) {
                    return true; // Un voisin trop bas trouvé : case instable
                }
            }
        }

        return false; // Aucun voisin trop bas : case stable
    }
}
