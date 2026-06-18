package iut.sae.algo.sobriete.etu3;

public class TasDeSable {
    public static int[][] effondrer(int[][] bac) {
        if (bac == null || bac.length == 0 || bac[0].length == 0) return bac;
        int ligne = bac.length, cols = bac[0].length;
        boolean modifie = true;
        while (modifie) {
            modifie = false;
            for (int r = 0; r < ligne; r++)
                for (int c = 0; c < cols; c++) {
                    int v = bac[r][c];
                    if (v == 0) continue;
                    if (r > 0 && bac[r-1][c] < v-1) { bac[r][c]--; bac[r-1][c]++; modifie = true; v--; }
                    if (c < cols-1 && bac[r][c+1] < v-1) { bac[r][c]--; bac[r][c+1]++; modifie = true; v--; }
                    if (r < ligne-1 && bac[r+1][c] < v-1) { bac[r][c]--; bac[r+1][c]++; modifie = true; v--; }
                    if (c > 0 && bac[r][c-1] < v-1) { bac[r][c]--; bac[r][c-1]++; modifie = true; }
                }
        }
        return bac;
    }
}
