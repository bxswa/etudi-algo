package iut.sae.algo.mini;


public class TasDeSable {
 /*
     * Effondre un bac de sable jusqua stabilisation
     *
     * @param b le tableau 2D initial 
     * @return un nouveau tableau stabilise
     */
    public static int[][] effondrer(int[][] b) {
        if (b == null || b.length == 0 || b[0].length == 0)
            return b;
        
        int l = b.length;
        int c = b[0].length;
        int[][] g = new int[l][c];
        
        for (int i = 0; i < l; i++)
            g[i] = b[i].clone();
        
        int[] dl = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean s;
        
        do {
            s = false;
            
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < 4; k++) {
                        int vi = i + dl[k];
                        int vj = j + dc[k];
                        
                        if (vi >= 0 && vi < l && vj >= 0 && vj < c) {
                            if (g[i][j] - g[vi][vj] >= 2) {
                                g[i][j]--;
                                g[vi][vj]++;
                                s = true;
                          }
                        }
             }
    }
         }
            
        } while (s);
        
        return g;
    }
}