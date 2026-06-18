package iut.sae.algo.simplicite.etu79;

public class TasDeSable {

    private static final int HAUT = 0;
    private static final int DROITE = 1;
    private static final int BAS = 2;
    private static final int GAUCHE = 3;



    // la fonction principale qui effondre le bac de sable, tant que le bac est instable en appelant la fonction faireTomberCase sur chaque case du bac.
    public static int[][] effondrer(int[][] bac) {

        // on filtre d'abord les cas particuliers
        if (bac == null || bac.length == 0) {
        return bac;
    }

        if (bac[0].length == 0) {
            return copier(bac);
        }
        // on fait une copie du bac pour ne pas le modifier
        int[][] res = copier(bac);

        // tant que le bac est instable, on fait tomber les grains
        while (estInstable(res)) {
            for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                faireTomberCase(res, i, j);
            }
        }
        }

        return res;
    }


    // la fonction faireTomberCase qui fait tomber un grain de sable d'une case, si elle est instable, dans les 4 directions possibles (haut, droite, bas, gauche) 
    // en vérifiant à chaque fois si le grain peut tomber dans la direction choisie
    private static void faireTomberCase(int[][] bac, int i, int j) {
        if (!doitTomber(bac, i, j)) {
            return;
        }
        // on commence par le haut, puis on tourne dans le sens des aiguilles d'une montre
        int direction = HAUT;

        for (int essais = 0; essais < 4; essais++) {
            if (peutTomberDansDirection(bac, i, j, direction)) {
                deplacerUnGrain(bac, i, j, direction);
            }
            direction = directionSuivante(direction);
        }
    }

    // la fonction doitTomber qui vérifie si une case est instable, c'est à dire si elle contient plus d'un grain de sable 
    // que l'une de ses cases adjacentes
    public static boolean doitTomber(int[][] bac, int i, int j) {
        int valeur = bac[i][j];

        // on vérifie les 4 cases adjacentes, en prenant soin de ne pas sortir du bac
        if (i > 0 && valeur - bac[i - 1][j] > 1) return true;
        if (j < bac[i].length - 1 && valeur - bac[i][j + 1] > 1) return true;
        if (i < bac.length - 1 && valeur - bac[i + 1][j] > 1) return true;
        if (j > 0 && valeur - bac[i][j - 1] > 1) return true;

        return false;
    }

    // la fonction estInstable qui vérifie si le bac est instable, c'est à dire s'il existe au moins une case qui doit tomber
    public static boolean estInstable(int[][] bac) {
        // on parcourt toutes les cases du bac pour vérifier si l'une d'entre elles doit tomber, puis on re
        for (int i = 0; i < bac.length; i++) {
            for (int j = 0; j < bac[i].length; j++) {
                if (doitTomber(bac, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    // la fonction peutTomberDansDirection qui vérifie si un grain de sable peut tomber dans une direction donnée, 
    // en vérifiant que la case d'arrivée existe et que la différence de grains entre la case de départ et la case d'arrivée est supérieure à 1
    private static boolean peutTomberDansDirection(int[][] bac, int i, int j, int direction) {
        int ni = i;
        int nj = j;

        if (direction == HAUT) ni--;
        else if (direction == DROITE) nj++;
        else if (direction == BAS) ni++;
        else nj--;

        if (ni < 0 || ni >= bac.length) return false;
        if (nj < 0 || nj >= bac[ni].length) return false;

        return bac[i][j] - bac[ni][nj] > 1;
    }

    // la fonction deplacerUnGrain qui déplace un grain de sable d'une case vers une autre,
    //  en modifiant les valeurs des cases de départ et d'arrivée
    private static void deplacerUnGrain(int[][] bac, int i, int j, int direction) {
        bac[i][j]--;

        if (direction == HAUT) bac[i - 1][j]++;
        else if (direction == DROITE) bac[i][j + 1]++;
        else if (direction == BAS) bac[i + 1][j]++;
        else bac[i][j - 1]++;
    }

    // la fonction directionSuivante qui retourne la direction suivante dans le sens des aiguilles d'une montre
    private static int directionSuivante(int direction) {
        return (direction + 1) % 4;
    }

    // la fonction copier qui fait une copie d'un bac de sable, pour éviter de modifier le bac original

    private static int[][] copier(int[][] bac) {
        int[][] copie = new int[bac.length][];

        for (int i = 0; i < bac.length; i++) {
            copie[i] = new int[bac[i].length];
            for (int j = 0; j < bac[i].length; j++) {
                copie[i][j] = bac[i][j];
            }
        }

        return copie;
    }




}
