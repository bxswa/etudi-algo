package iut.sae.algo.simplicite.etu65;

public class TasDeSable {
    public static int[][] effondrer(int bac[][]) {
        boolean est_instable = true; // on initilise une variable pour savoir si le bac est instable ou pas (par defaut, in sera instable)
        while (est_instable){ // tant que le bac est instable, on continue la boucle
            est_instable = false;

            // longueur de la table principale du bac (le nombre de ligne)
            for(int ligne = 0; ligne < bac.length; ligne++){

                // longueur de la table secondaire du bac (le nombre de colonne)
                for (int colonne = 0; colonne < bac[0].length;colonne++){


                    // on regarde les 4 cases autours de notre case actuelle.
                    // si la case du haut a une valeur plus petite de 2 que la case actuelle, alors :

                    if (ligne > 0 && bac[ligne][colonne] - bac[ligne-1][colonne] >= 2){
                        bac[ligne-1][colonne] = bac[ligne-1][colonne] +1; // HAUT
                        bac[ligne][colonne] = bac[ligne][colonne] -1;
                        est_instable = true;
                    }


                    // si la case de droite a une valeur plus petite que 2 que celle de la case actuelle, alors :

                    if (colonne < bac[0].length -1 && (bac[ligne][colonne] - bac[ligne][colonne+1] >= 2)){
                        bac[ligne][colonne+1] = bac[ligne][colonne+1] +1 ; // DROITE
                        bac[ligne][colonne] = bac[ligne][colonne] -1;
                        est_instable = true;
                    }


                    // si la case de bas a une valeur plus petite que 2 que celle de la case actuelle, alors :

                    if (ligne < bac.length -1 && (bac[ligne][colonne] - bac[ligne+1][colonne] >= 2)){
                        bac[ligne+1][colonne] = bac[ligne+1][colonne] +1; //BAS
                        bac[ligne][colonne] = bac[ligne][colonne] -1;
                        est_instable = true;
                    }


                    // si la case de gauche a une valeur plus petite que 2 que celle de la case actuelle, alors :

                    if (colonne > 0 && (bac[ligne][colonne] - bac[ligne][colonne-1] >= 2)){
                        bac[ligne][colonne-1] = bac[ligne][colonne-1] +1; //GAUCHE
                        bac[ligne][colonne] = bac[ligne][colonne] -1;
                        est_instable = true;
                    }
                }
            }
        }
        
        // a la fin de la boucle, le bac est stable. On peut donc le retouner 
        return bac;
    }
} 
