package iut.sae.algo.efficacite;

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
            //clone() sur int[] et est de complexite O(n) ou n = nombre de colonnes
        }

        int minL = 0, maxL = lignes - 1;
        int minC = 0, maxC = colonnes - 1;

        int[] deltaLignes = {-1, 0, 1, 0};
        int[] deltaColonnes = {0, 1, 0, -1};

        boolean stable;

        do {
            stable = true;

            int prochainMinL = lignes, prochainMaxL = -1;
            int prochainMinC = colonnes, prochainMaxC = -1;


            for (int l = minL; l <= maxL; l++) {
                for (int c = minC; c <= maxC; c++) {

                    for (int i = 0; i < 4; i++) {
                        int vLigne = l + deltaLignes[i];
                        int vColonne = c + deltaColonnes[i];

                        if (vLigne >= 0 && vLigne < lignes && vColonne >= 0 && vColonne < colonnes) {
                            if (grille[l][c] - grille[vLigne][vColonne] >= 2) {
                                grille[l][c]--;
                                grille[vLigne][vColonne]++;
                                stable = false;
                                prochainMinL = Math.min(prochainMinL, Math.min(l, vLigne));
                                prochainMaxL = Math.max(prochainMaxL, Math.max(l, vLigne));
                                prochainMinC = Math.min(prochainMinC, Math.min(c, vColonne));
                                prochainMaxC = Math.max(prochainMaxC, Math.max(c, vColonne));
                                //Math.min() / Math.max() sont de complexite O(1)
                            }
                     }
                    }
                }
         }


        } while (!stable);
        return grille;
    }
}