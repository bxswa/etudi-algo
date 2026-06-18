package iut.sae.algo.sobriete.etu68;

public class TasDeSable {

    public static int[][] effondrer(int bac[][]) throws NullPointerException {

        if (bac == null) {
            throw new NullPointerException();
        }

        boolean asPerm = true;

        while (asPerm) {
            asPerm = false;

            for (int i = 0; i<bac.length;i++) {
                 for (int j = 0;j<bac[0].length; j++) {
                     if (bac[i][j] > 0) {
                        if (i > 0 && bac[i][j] - bac[i - 1][j] > 1) {
                            bac[i][j]--;
                            bac[i - 1][j]++;
                            asPerm = true;
                        }
                        if (j < bac[0].length - 1 && bac[i][j] - bac[i][j + 1] > 1) {
                            bac[i][j]--;
                            bac[i][j + 1]++;
                            asPerm = true;
                        }
                        if (i < bac.length - 1 && bac[i][j] - bac[i + 1][j] > 1) {
                            bac[i][j]--;
                            bac[i + 1][j]++;
                            asPerm = true;
                        }

                        if (j > 0 && bac[i][j] - bac[i][j - 1] > 1) {
                            bac[i][j]--;
                            bac[i][j - 1]++;
                            asPerm = true;
                        }
                    }
                }
            }
        }

    
       


        return bac;
    }



}
    
