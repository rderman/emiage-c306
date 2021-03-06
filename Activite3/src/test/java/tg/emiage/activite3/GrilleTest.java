/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.emiage.activite3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rachid
 */
public class GrilleTest {

    /**
     * Constante du caractère vide d'une celle.
     */
    static final char VIDE = Grille.EMPTY;
    /**
     * Resultat test attendu pour getDimension.
     */
    static final int DIMENSION_EXP_RESULT = 9;
    /**
     * Valeur de x pour setValue.
     */
    static final int GRILLE_SET_V_X = 7;
    /**
     * Valeur de Y pour set Value.
     */
    static final int GRILLE_SET_V_Y = 2;
    /**
     * Value to set.
     */
    static final char GRILLE_XY_SET = '9';
    /**
     * GET VALUE X.
     */
    static final char GET_V_X = '6';
    /**
     * GET VALUE Y.
     */
    static final char GET_V_Y = '7';
    /**
     * POSSIBLE X.
     */
    static final int POSSBL_X = 7;
    /**
     * POSSIBLE Y.
     */
    static final int POSSBL_Y = 8;
    /**
     * POSSIBLE VALUE.
     */
    static final char POSSBL_VALUE = '7';

    /**
     * Grille de test.
     */
    static final char[][] TEST_GRILLE
            = {
                {VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, VIDE, VIDE, '3', VIDE, '8', '5'},
                {VIDE, VIDE, '1', VIDE, '2', VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, '5', VIDE, '7', VIDE, VIDE, VIDE},
                {VIDE, VIDE, '4', VIDE, VIDE, VIDE, '1', VIDE, VIDE},
                {VIDE, '9', VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, VIDE},
                {'5', VIDE, VIDE, VIDE, VIDE, VIDE, VIDE, '7', '3'},
                {VIDE, VIDE, '2', VIDE, '1', VIDE, VIDE, VIDE, VIDE},
                {VIDE, VIDE, VIDE, VIDE, '4', VIDE, VIDE, VIDE, '9'}
            };

    /**
     * Constructeur par défaut.
     */
    public GrilleTest() {
    }

    /**
     * Test of getDimension method, of class Grille.
     */
    @Test
    public final void testGetDimension() {
        System.out.println("getDimension");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        int resultat = instance.getDimension();
        assertEquals(DIMENSION_EXP_RESULT, resultat);
        System.out.println("Dimension de la Grille = " + resultat);
    }
    
    /**
     * Test of setValue method, of class Grille.
     */
    @Test
    public final void testSetValue() {
        System.out.println("setValue");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        instance.setValue(GRILLE_SET_V_X, GRILLE_SET_V_Y, GRILLE_XY_SET);
        System.out.println("Execution de méthode setValue");
    }

    /**
     * Test of getValue method, of class Grille.
     */
    @Test
    public final void testGetValue() {
        System.out.println("getValue");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        char resultat = instance.getValue(GET_V_X, GET_V_Y);
        if (resultat != '7') {
            fail("cas getValue Valeurs différentes");
        }
        System.out.println("Résultat ok pour exécution de getValue " + String.valueOf(resultat));
    }

    
    /**
     * Test of the complete methode of the class Grille.
     */
    @Test
    public final void testComplete() {
        System.err.println("complete");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        boolean resultat = instance.complete();
        assertEquals(false, resultat);
        System.out.println("Exécution de la méthode complete pour Result FALSE");

    }
    
    /**
     * Test of the possible methode of the class Grille.
     */
    @Test
    public final void testPossible(){
        System.out.println("possible");
        Grille instance = new GrilleImpl(TEST_GRILLE);
        boolean resulat = instance.possible(POSSBL_X, POSSBL_Y, POSSBL_VALUE);
        assertEquals(true, resulat);
        System.out.println("Exécution de la méthode possible pour status TRUE");
        
    }
    
    /**
     * Main Method.
     * @param args arguments
     */
    public static void main(String[] args) {
        GrilleTest test = new GrilleTest();
        
        test.testGetDimension();
        test.testSetValue();
        test.testComplete();
        test.testPossible();
        //Merci de décommenter la ligne ci-dessous pour le test avec
        //exceptionµ
//        test.testGetValue();
    }
}
