package iut.sae.algo.efficacite.etu33;

/**
 * Effondre le tas de sable jusqu'à stabilisation.
 *
 * Complexité :
 * - Soit j = nombre de lignes, i = nombre de colonnes
 * - Un parcours complet coûte O(j*i)
 * - La boucle while dépend du nombre d'effondrements nécessaires
 * - Complexité totale : O(k*j*i) avec k = nombre de passages avant stabilisation
 */
public class TasDeSable {

    public static int[][] effondrer(int[][] bac) {
        boolean modif = true;

        while (modif) {
            modif = false;

            for (int i = 0; i < bac.length; i++) {
                for (int j = 0; j < bac[i].length; j++) {
                    //U
                    if (i > 0 && bac[i - 1][j] + 1 < bac[i][j]) {
                        bac[i - 1][j]++;
                        bac[i][j]--;
                        modif = true;
                    }

                    //R
                    if (j + 1 < bac[i].length && bac[i][j + 1] + 1 < bac[i][j]) {
                        bac[i][j + 1]++;
                        bac[i][j]--;
                        modif = true;
                    }

                    //D
                    if (i + 1 < bac.length && bac[i + 1][j] + 1 < bac[i][j]) {
                        bac[i + 1][j]++;
                        bac[i][j]--;
                        modif = true;
                    }

                    //L
                    if (j > 0 && bac[i][j - 1] + 1 < bac[i][j]) {
                        bac[i][j - 1]++;
                        bac[i][j]--;
                        modif = true;
                    }
                }
            }
        }

        return bac;
    }
}
