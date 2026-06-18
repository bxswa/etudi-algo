package iut.sae.algo.sobriete.etu27;

public class TasDeSable {
    public static int[][] effondrer(int[][] bac)   {


        boolean aBouge = true;

        while (aBouge) {
            aBouge = false;

            

            for (int i = 0; i < bac.length; i++) {
                for (int j = 0; j < bac[i].length; j++) {
                    // haut
                    if (i > 0 && bac[i][j] - bac[i-1][j] > 1) {
                        bac[i][j] = bac[i][j] - 1;
                        bac[i-1][j] = bac[i-1][j] + 1;
                        aBouge = true;
                    }

                    // droite
                    if (j < bac[i].length - 1 && bac[i][j] - bac[i][j+1] > 1) {
                        bac[i][j] = bac[i][j] - 1;
                        bac[i][j+1] = bac[i][j+1] + 1;
                        aBouge = true;
                    }
                    // bas
                    if (i < bac.length - 1 && bac[i][j] - bac[i+1][j] > 1) {
                        bac[i][j] = bac[i][j] - 1;
                        bac[i+1][j] = bac[i+1][j] + 1;
                        aBouge = true;
                    }
                    // gauche
                    if (j > 0 && bac[i][j] - bac[i][j-1] > 1) {
                        bac[i][j] = bac[i][j] - 1;
                        bac[i][j-1] = bac[i][j-1] + 1;
                        aBouge = true;
                    }
                }
            }
        }





        return bac;
    }
}
