package iut.sae.algo.efficacite.etu24;

public class TasDeSable {

    /**
     * Simule l'effondrement d'un tas de sable
     * Complexité : O(p × n × m)
     * p = nombre de passes, n = lignes, m = colonnes
     */
    public static int[][] effondrer(int[][] bac) {
        boolean modif = true;
        while (modif) {
            modif = false;  // O(p)
            for (int i = 0; i < bac.length; i++) {  // O(n)
                int[] ligneActuelle = bac[i];
                for (int j = 0; j < ligneActuelle.length; j++) {    // O(m)
                    // Case stable
                    if (ligneActuelle[j] <= 1) {    // O(1)
                        continue;
                    }
                    int valeur = ligneActuelle[j];
                    boolean aCoule = false;
                    // Haut
                    if (i > 0 && valeur > bac[i - 1][j] + 1) {  // O(1)
                        ligneActuelle[j]--;
                        bac[i - 1][j]++;
                        valeur = ligneActuelle[j];
                        aCoule = true;
                    }
                    // Droite
                    if (j + 1 < ligneActuelle.length && valeur > ligneActuelle[j + 1] + 1) {    // O(1)
                        ligneActuelle[j]--;
                        ligneActuelle[j + 1]++;
                        valeur = ligneActuelle[j];
                        aCoule = true;
                    }
                    // Bas
                    if (i + 1 < bac.length && valeur > bac[i + 1][j] + 1) { // O(1)
                        ligneActuelle[j]--;
                        bac[i + 1][j]++;
                        valeur = ligneActuelle[j];
                        aCoule = true;
                    }
                    // Gauche
                    if (j > 0 && valeur > ligneActuelle[j - 1] + 1) {   // O(1)
                        ligneActuelle[j]--;
                        ligneActuelle[j - 1]++;
                        aCoule = true;
                    }
                    // Modif
                    if (aCoule) {
                        modif = true;
                    }
                }
            }
        }
        return bac; // O(1)
    }
}
