package iut.sae.algo.sobriete.etu55;

/**
 * Cette classe fournit un algorithme sobre et optimisé pour simuler 
 * un effondrement de tas de sable.
 * 
 * L'algorithme met en oeuvre une zone active qui s'adapte pas à pas 
 * à l'étalement du sable, évitant ainsi le coût énergétique d'un parcours 
 * complet et systématique de la grille à chaque itération.
 * 
 */
public class TasDeSable {

    /**
     * Simule l'effondrement en chaîne d'un tas de sable contenu dans un bac, 
     * en limitant les scans à la zone utile et en minimisant les écritures en RAM.
     */
    public static int[][] effondrer(int[][] bac) {
        int h = bac.length;
        if (h == 0) return bac;
        int l = bac[0].length;

        int iMin = h - 1;
        int iMax = 0;
        int jMin = l - 1;
        int jMax = 0;
        boolean contientDuSable = false;

        //Calcul du rayon utile (on fais un parcours complet de la grille pour localiser les grains existants initiale)
        //On vien redélimiter un nouveau bac (théoriquement plus petit)
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (bac[i][j] > 0) {
                    contientDuSable = true;
                    if (i < iMin) iMin = i;
                    if (i > iMax) iMax = i;
                    if (j < jMin) jMin = j;
                    if (j > jMax) jMax = j;
                }
            }
        }

        //Si le bac est complètement vide, on s'arrête immédiatement
        if (!contientDuSable) {
            return bac;
        }

        //Ajout d'une marge de sécurité de 1 case tout autour pour anticiper l'effondrement possible
        if (iMin > 0) iMin--;
        if (iMax < h - 1) iMax++;
        if (jMin > 0) jMin--;
        if (jMax < l - 1) jMax++;

        boolean run = true;
        //Si changement effectuer on recommence
        while (run) {
            run = false;
            //Parcour du petit bac de haut en bas et de droite à gauche
            for (int i = iMin; i <= iMax; i++) {
                for (int j = jMin; j <= jMax; j++) {
                    //Utilisation de variable local pour éviter l'appel en mémoire
                    int valI = bac[i][j];
                    int val = valI;
                    //Une case avec 0 ou 1 grain ne peut jamais déborder (donc pas pris en compte)
                    if (val > 1) {
                        //Effondrement Haut
                        if (i - 1 >= 0 && val > bac[i - 1][j] + 1) {
                            val--;
                            bac[i - 1][j]++;
                            run = true;
                        }
                        //Effondrement Droit
                        if (j + 1 < l && val > bac[i][j + 1] + 1) {
                            val--;
                            bac[i][j + 1]++;
                            run = true;
                        }
                        //Effondrement Bas
                        if (i + 1 < h && val > bac[i + 1][j] + 1) {
                            val--;
                            bac[i + 1][j]++;
                            run = true;
                        }
                        //Effondrement Gauche
                        if (j - 1 >= 0 && val > bac[i][j - 1] + 1) {
                            val--;
                            bac[i][j - 1]++;
                            run = true;
                        }
                        //Si la val n'a pas changé on évite de mettre à jour pour rien (réduit le nombre d'appel en mémoire)
                        if (val != valI) {
                            bac[i][j] = val;
                        }
                    }
                }
            }
            //A la fin du while, ssi du sable a bougé on risque d'avoir un problème de taille donc : 
            if (run) {
                //On agrandit le petit bac Haut,Bas,Droite,Gauche
                if (iMin > 0) iMin--;
                if (iMax < h - 1) iMax++;
                if (jMin > 0) jMin--;
                if (jMax < l - 1) jMax++;
            }
        }

        return bac;
    }
}
