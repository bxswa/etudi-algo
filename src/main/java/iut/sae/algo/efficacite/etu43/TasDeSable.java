package iut.sae.algo.efficacite.etu43;
import java.util.ArrayDeque;

public class TasDeSable {

    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    public static void stabilize(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isUnstable(grid, r, c)) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] pos = queue.poll();

            int r = pos[0];
            int c = pos[1];

            if (!isUnstable(grid, r, c))
                continue;

            grid[r][c] -= 4;

            for (int i = 0; i < 4; i++) {

                int nr = r + DR[i];
                int nc = c + DC[i];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols) {

                    grid[nr][nc]++;

                    if (isUnstable(grid, nr, nc)) {
                        queue.add(new int[]{nr, nc});
                    }
                }
            }

            if (isUnstable(grid, r, c)) {
                queue.add(new int[]{r, c});
            }
        }
    }

    static boolean isUnstable(int[][] g, int r, int c) {

        int v = g[r][c];

        if (r > 0 && v - g[r - 1][c] > 1) return true;
        if (c < g[0].length - 1 && v - g[r][c + 1] > 1) return true;
        if (r < g.length - 1 && v - g[r + 1][c] > 1) return true;
        if (c > 0 && v - g[r][c - 1] > 1) return true;

        return false;
    }
}
