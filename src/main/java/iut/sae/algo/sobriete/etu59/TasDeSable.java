package iut.sae.algo.sobriete.etu59;

public class TasDeSable {
    public static int[][] effondrer(int bac[][]) {
        if (bac.length == 0 || bac[0].length == 0) return bac;
        if (bac.length == 1 && bac[0].length == 1) return bac;

        int nbLignes = bac.length;
        int nbColonnes = bac[0].length;

        // on copie le bac
        int[][] res = new int[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                res[i][j] = bac[i][j];
            }
        }
        // si rien n'a change pendant un passage, c'est stable
        boolean aChange = true;
        while (aChange) {
            aChange = false;
            for (int i = 0; i < nbLignes; i++) {
                for (int j = 0; j < nbColonnes; j++) {
                    // haut
                    if (i - 1 >= 0 && res[i][j] - res[i-1][j] > 1) {
                        res[i][j]--;
                        res[i-1][j]++;
                        aChange = true;
                    }
                    // droite
                    if (j + 1 < nbColonnes && res[i][j] - res[i][j+1] > 1) {
                        res[i][j]--;
                        res[i][j+1]++;
                        aChange = true;
                    }
                    // bas
                    if (i + 1 < nbLignes && res[i][j] - res[i+1][j] > 1) {
                        res[i][j]--;
                        res[i+1][j]++;
                        aChange = true;
                    }
                    // gauche
                    if (j - 1 >= 0 && res[i][j] - res[i][j-1] > 1) {
                        res[i][j]--;
                        res[i][j-1]++;
                        aChange = true;
                    }
                }
            }
        }

        return res;
    }
}
