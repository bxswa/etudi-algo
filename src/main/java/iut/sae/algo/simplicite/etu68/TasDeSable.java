package iut.sae.algo.simplicite.etu68;

public class TasDeSable {

    public static int[][] effondrer(int[][] bac) {

        if (bac == null) {
            throw new NullPointerException();
        }

        int n = bac.length;
        if (n == 0) {
            return new int[0][0];
        }
        int m = bac[0].length;

        boolean modif = true;

        while (modif) {
            modif = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // haut
                    if (i > 0 && bac[i][j] - bac[i - 1][j] > 1) {
                        bac[i][j]--;
                        bac[i - 1][j]++;
                        modif = true;
                    }

                    // droite
                    if (j < m - 1 && bac[i][j] - bac[i][j + 1] > 1) {
                        bac[i][j]--;
                        bac[i][j + 1]++;
                        modif = true;
                    }

                    // bas
                    if (i < n - 1 && bac[i][j] - bac[i + 1][j] > 1) {
                        bac[i][j]--;
                        bac[i + 1][j]++;
                        modif = true;
                    }

                    // gauche
                    if (j > 0 && bac[i][j] - bac[i][j - 1] > 1) {
                        bac[i][j]--;
                        bac[i][j - 1]++;
                        modif = true;
                    }
                }
            }
        }

        return bac;
    }
}
