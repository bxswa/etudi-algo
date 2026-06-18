package iut.sae.algo.simplicite.etu77;

public class TasDeSable {
    
    /**
     * Stabilise un tas de sable en répartissant les grains
     * vers les cases voisines lorsque la différence dépasse 1.
     *
     * @param bac état initial du bac
     * @return état stabilisé du bac
     */

    public static int[][] effondrer(int[][] bac) {

        if (bac == null) {
            return null;
        }

        int[][] resultat = new int[bac.length][];

        for (int i = 0; i < bac.length; i++) {
            resultat[i] = bac[i].clone();
        }

        boolean stable = false;

        while (!stable) {
            stable = true;

            for (int ligne = 0; ligne < resultat.length; ligne++) {
                for (int colonne = 0; colonne < resultat[ligne].length; colonne++) {

                    if (ligne > 0
                            && resultat[ligne][colonne] - resultat[ligne - 1][colonne] > 1) {
                        resultat[ligne][colonne]--;
                        resultat[ligne - 1][colonne]++;
                        stable = false;
                    }

                    if (colonne < resultat[ligne].length - 1
                            && resultat[ligne][colonne] - resultat[ligne][colonne + 1] > 1) {
                        resultat[ligne][colonne]--;
                        resultat[ligne][colonne + 1]++;
                        stable = false;
                    }

                    if (ligne < resultat.length - 1
                            && resultat[ligne][colonne] - resultat[ligne + 1][colonne] > 1) {
                        resultat[ligne][colonne]--;
                        resultat[ligne + 1][colonne]++;
                        stable = false;
                    }

                    if (colonne > 0
                            && resultat[ligne][colonne] - resultat[ligne][colonne - 1] > 1) {
                        resultat[ligne][colonne]--;
                        resultat[ligne][colonne - 1]++;
                        stable = false;
                    }
                }
            }
        }

        return resultat;
    }
}
