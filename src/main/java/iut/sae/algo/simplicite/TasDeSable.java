package iut.sae.algo.simplicite;

public class TasDeSable {
    /*
     * Effondre un bac de sable jusqua stabilisation
     *
     * @param bac le tableau 2D initial
     * @return le tableau stabilise
     */
    public static int[][] effondrer(int[][] bac) {
        if (bac == null || bac.length == 0 || bac[0].length == 0) {
            return bac;
        }

        int lignes = bac.length;
        int colonnes = bac[0].length;

        int[][] grille = new int[lignes][colonnes];
        for (int i = 0; i < lignes; i++) {
            grille[i] = bac[i].clone();
     }

        boolean stable;

        do {
            stable = false;

            for (int l = 0; l < lignes; l++) {
                for (int c = 0; c < colonnes; c++) {

                    int[] deltaLignes = {-1, 0, 1, 0};
                    int[] deltaColonnes = {0, 1, 0, -1};

                    for (int i = 0; i < 4; i++) {
                        int vLigne = l + deltaLignes[i];
                        int vColonne = c + deltaColonnes[i];

                        if (vLigne >= 0 && vLigne < lignes && vColonne >= 0 && vColonne < colonnes) {
                            
                            if (grille[l][c] - grille[vLigne][vColonne] >= 2) {
                                grille[l][c]--;
                                grille[vLigne][vColonne]++;
                                stable = true; 
                            }
                    }
                    }

                }
            }
        } while (stable);

        return grille;
    }
}