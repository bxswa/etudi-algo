package iut.sae.algo;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import junit.framework.TestCase;

//Ligne d'import à faire varier selon le type d'algorithme
import iut.sae.algo.simplicite.etu55.*;
//TasDeSable;

public class TasDeSableTest extends TestCase{
        
    @Test
    public void testBacNul(){
        int[][] bac={{}};
        int[][] objectif={{}};
        assertBacEquals(objectif, effondrer(bac));
    }

    @Test
    public void testBacVide(){
        int[][] bac={
                {0,0,0},
                {0,0,0},
                {0,0,0}};
        int[][] objectif={
                {0,0,0},
                {0,0,0},
                {0,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    @Test
    public void testBacTropPetit(){
        int[][] bac={
                {5}};
        int[][] objectif={
                {5}};
        assertBacEquals(objectif, effondrer(bac));
    }

    @Test
    public void testBacPlat(){
        int[][] bac={
                {5,5,5},
                {5,5,5},
                {5,5,5}};
        int[][] objectif={
                {5,5,5},
                {5,5,5},
                {5,5,5}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    @Test
    public void testTasSimple(){
        int[][] bac={
                {0,0,0},
                {0,5,0},
                {0,0,0}};
        int[][] objectif={
                {0,1,0},
                {1,1,1},
                {0,1,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    @Test
    public void testTasSimpleStable(){
        int[][] bac={
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        int[][] objectif={
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    @Test
    public void testTrou(){
        int[][] bac={
                {5,5,5},
                {5,4,5},
                {5,6,5}};
        int[][] objectif={
                {5,5,5},
                {5,5,5},
                {5,5,5}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testPartiel1(){
        int[][] bac={
                {0,0,0},
                {0,2,0},
                {0,0,0}};
        int[][] objectif={
                {0,1,0},
                {0,1,0},
                {0,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testPartiel2(){
        int[][] bac={
                {0,0,0},
                {0,3,0},
                {0,0,0}};
        int[][] objectif={
                {0,1,0},
                {0,1,1},
                {0,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    public void testPartiel3(){
        int[][] bac={
                {0,0,0},
                {0,4,0},
                {0,0,0}};
        int[][] objectif={
                {0,1,0},
                {0,1,1},
                {0,1,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testTasCoin1HG(){
        int[][] bac={
                {1,0,0},
                {0,0,0},
                {0,0,0}};
        int[][] objectif={
                {1,0,0},
                {0,0,0},
                {0,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testTasCoin1HD(){
        int[][] bac={
                {0,0,1},
                {0,0,0},
                {0,0,0}};
        int[][] objectif={
                {0,0,1},
                {0,0,0},
                {0,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    public void testTasCoin1BG(){
        int[][] bac={
                {0,0,0},
                {0,0,0},
                {1,0,0}};
        int[][] objectif={
                {0,0,0},
                {0,0,0},
                {1,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    public void testTasCoin1BD(){
        int[][] bac={
                {0,0,0},
                {0,0,0},
                {0,0,1}};
        int[][] objectif={
                {0,0,0},
                {0,0,0},
                {0,0,1}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testTasCoin10HG(){
        int[][] bac={
                {10,0,0},
                {0,0,0},
                {0,0,0}};
        int[][] objectif={
                {2,2,1},
                {2,1,1},
                {1,0,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testTasCoin10HD(){
        int[][] bac={
                {0,0,10},
                {0,0,0},
                {0,0,0}};
        int[][] objectif={
                {1,2,2},
                {0,1,2},
                {0,1,1}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    public void testTasCoin10BG(){
        int[][] bac={
                {0,0,0},
                {0,0,0},
                {10,0,0}};
        int[][] objectif={
                {1,1,0},
                {2,1,0},
                {2,2,1}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    public void testTasCoin10BD(){
        int[][] bac={
                {0,0,0},
                {0,0,0},
                {0,0,10}};
        int[][] objectif={
                {0,1,1},
                {0,1,2},
                {1,2,2}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testTasLigneH(){
        int[][] bac={
                {4,4,4},
                {0,0,0},
                {0,0,0}};
        int[][] objectif={
                {2,2,2},
                {1,1,1},
                {1,1,1}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testTasLigneB(){
        int[][] bac={
                {0,0,0},
                {0,0,0},
                {4,4,4}};
        int[][] objectif={
                {1,1,1},
                {1,1,1},
                {2,2,2}};
        assertBacEquals(objectif, effondrer(bac));
    }

    
    public void testTasLigneC(){
        int[][] bac={
                {0,0,0},
                {4,4,4},
                {0,0,0}};
        int[][] objectif={
                {1,1,1},
                {2,2,2},
                {1,1,1}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testDoubleTas5(){
        int[][] bac={
                {0,0,0,0,0},
                {0,5,0,0,0},
                {0,0,0,0,0},
                {0,0,0,5,0},
                {0,0,0,0,0}};
        int[][] objectif={
                {0,1,0,0,0},
                {1,1,1,0,0},
                {0,1,0,1,0},
                {0,0,1,1,1},
                {0,0,0,1,0}};
        assertBacEquals(objectif, effondrer(bac));
    }
    
    public void testDoubleTas10(){
        int[][] bac={
                {0,0,0,0,0},
                {0,10,0,0,0},
                {0,0,0,0,0},
                {0,0,0,10,0},
                {0,0,0,0,0}};
        int[][] objectif={
                {1,1,1,0,0},
                {1,2,1,1,0},
                {1,1,1,1,1},
                {0,0,1,2,1},
                {0,0,1,1,1}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void test500(){
        int[][] bac = new int[11][11];
        bac[5][5]=500;
        int[][] objectif={
                {0,1,2,3,4,5,4,3,2,1,1},
                {1,2,3,4,5,6,5,4,3,2,1},
                {2,3,4,5,6,7,6,5,4,3,2},
                {3,4,5,6,7,8,7,6,5,4,3},
                {4,5,6,7,8,8,8,7,6,5,4},
                {4,5,6,7,8,9,8,7,6,5,4},
                {3,4,5,6,7,8,7,6,5,5,4},
                {2,3,4,5,6,7,6,5,4,4,3},
                {1,2,3,4,5,6,5,4,4,3,2},
                {0,1,2,3,4,5,4,3,3,2,1},
                {0,1,2,2,3,4,3,2,2,1,0}};
        assertBacEquals(objectif, effondrer(bac));
    }

    public void testIUT(){
        int[][] bac={
                {0,9,0,9,0,9,9,9,9},
                {0,9,0,9,0,9,0,9,0},
                {0,9,0,9,9,9,0,9,0}};
        int[][] objectif={
                {3,4,5,5,6,6,6,6,6},
                {3,4,5,5,6,6,6,6,5},
                {3,4,4,5,6,6,5,5,4}};
        assertBacEquals(objectif, effondrer(bac));
    }


    /* 
    // Custom methods
    */
    protected int[][] effondrer(int[][] x) {
        return null;
    }

    public static void afficherBac(int[][] bac) {
        for (int[] ligne : bac) {// must use a, b as index name

            for (int valeur : ligne) {
                System.out.print(valeur + " ");
            }

            System.out.println();
        }
    }

    private void assertBacEquals(int[][] expecteds, int[][] actuals){
        try{
            assertArrayEquals(expecteds, actuals);
        }
        catch (AssertionError e) {
            System.out.println("=== ATTENDU ===");
            afficherBac(expecteds);

            System.out.println("=== OBTENU  ===");
            afficherBac(actuals);

            throw e;
        }

    }
}