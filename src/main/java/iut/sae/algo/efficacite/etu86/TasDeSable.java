package iut.sae.algo.efficacite.etu86;

public class TasDeSable {

    private static final int[] dirRow = { -1, 0, 1, 0 };
    private static final int[] dirColumn = { 0, 1, 0, -1 };

    public static int[][] effondrer(int bac[][]) {
        int row = bac.length;
        int column = bac[0].length;

        boolean hasMoved = false;

        int nextR, nextC;

        do {
            hasMoved = false;

            for (int indexR = 0; indexR < row; indexR++) {
                for (int indexC = 0; indexC < column; indexC++) {

                    for (int i = 0; i < 4; i++) {
                        nextR = indexR + dirRow[i];
                        nextC = indexC + dirColumn[i];

                        if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < column) {
                            if (bac[indexR][indexC] - bac[nextR][nextC] > 1) {
                                bac[indexR][indexC]--;
                                bac[nextR][nextC]++;
                                hasMoved = true;
                            }
                        }
                    }

                }
            }
        } while (hasMoved);
        
        return bac;
    }
}
