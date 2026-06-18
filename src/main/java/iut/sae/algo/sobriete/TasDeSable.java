package iut.sae.algo.sobriete;

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
        int vLigne, vColonne;

        do {
            stable = true;

            for (int l = 0; l < lignes; l++) {
                for (int c = 0; c < colonnes; c++) {

                    vLigne = l - 1;
                    if (vLigne >= 0) {
                        if (grille[l][c] - grille[vLigne][c] >= 2) {
                            grille[l][c]--;
                            grille[vLigne][c]++;
                            stable = false;
                        }
                    }

                    vColonne = c + 1;
                    if (vColonne < colonnes) {
                        if (grille[l][c] - grille[l][vColonne] >= 2) {
                            grille[l][c]--;
                            grille[l][vColonne]++;
                            stable = false;
                      }
                    }

                    vLigne = l + 1;
                    if (vLigne < lignes) {
                        if (grille[l][c] - grille[vLigne][c] >= 2) {
                            grille[l][c]--;
                            grille[vLigne][c]++;
                            stable = false;
                        }
                 }

                    vColonne = c - 1;
                    if (vColonne >= 0) {
                        if (grille[l][c] - grille[l][vColonne] >= 2) {
                            grille[l][c]--;
                            grille[l][vColonne]++;
                            stable = false;
                        }
                }
               }
            }

        } while (!stable);

        return grille;
    }
}