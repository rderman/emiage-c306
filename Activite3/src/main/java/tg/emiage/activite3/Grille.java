/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.emiage.activite3;

/**
 *
 * @author Rachid
 */
public interface Grille {

    /**
     * Caractere pour une case vide.
     */
    char EMPTY = '@';
    /**
     * Jeux de caractères possible à utiliser.
     */
    char[] POSSIBLE = new char[]{'1', '2', '3', '4', '5',
        '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Accesseur de l'interface.
     * @return largeur ou hauteur de la grille.
     */
    int getDimension();

   /**
    * Mutateur de l'interface.
    * @param x ligne
    * @param y colonne
    * @param value valeur
    * @throws IllegalArgumentException excp
    */
    void setValue(int x, int y, char value) throws IllegalArgumentException;

    /**
     * Accesseur de les Valeurs de l'interface.
     * @param x ligne
     * @param y colonne
     * @return char int
     * @throws IllegalArgumentException excep
     */
    char getValue(int x, int y) throws IllegalArgumentException;

    /**
     * Verifie si une grille est terminé.
     * @return true o
     */
    boolean complete();

    /**
     * Test si une valeur est possible dans la grille par rapport a ce qu'elle
     * contient deja.
     * @param x ligne
     * @param y colonne
     * @param value valeur
     * @return true bool
     * @throws IllegalArgumentException excep
     */
    boolean possible(int x, int y, char value) throws IllegalArgumentException;
}
