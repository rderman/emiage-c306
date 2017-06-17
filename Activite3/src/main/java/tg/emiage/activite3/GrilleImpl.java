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
public class GrilleImpl implements Grille {

    /**
     * Grille de sudoku.
     */
    private final char[][] grilleSudoku;

    /**
     * Constructeur par defaut.
     *
     * @param grille Grille
     */
    GrilleImpl(final char[][] grille) {
        this.grilleSudoku = grille;
    }

    /**
     * Accesseur grille Sudoku.
     *
     * @return char[] e
     */
    public final char[][] getGrilleSudoku() {
        return grilleSudoku;
    }

    /**
     * Retourne la dimension de la grille.
     *
     * @return int dimen
     */
    @Override
    public final int getDimension() {
        return this.getGrilleSudoku().length;
    }

    /**
     * Affecte une valeur dans une case de la grille.
     * @param x
     * @param y
     * @param value
     * @throws IllegalArgumentException uuu
     */
    @Override
    public final void setValue(final int x, final int y, final char value) 
            throws IllegalArgumentException {
        if (this.possible(x, y, value)) {
            String illegalArgMsg = "Valeur interdite aux vues des autres "
                    + "valeurs de la grille";
//          Verification de l'existance de la valeur dans la ligne x
            for (int j = 0; j < this.getDimension(); j++) {
                if (this.grilleSudoku[x][j] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }
//          Verification de l'existance de la valeur dans la colonne y
            for (int i = 0; i < this.getDimension(); i++) {
                if (this.grilleSudoku[i][y] == value) {
                    throw new IllegalArgumentException(illegalArgMsg);
                }
            }

//          Parcourir pour verifier l'existance de la valeur
            int taille = (int) Math.sqrt(this.getDimension());
            int i = (x / taille) * taille;
            int j = (y / taille) * taille;

            for (int r = 0; r < taille; r++) {
                for (int c = 0; c < taille; c++) {
                    if (this.grilleSudoku[i + r][j + c] == value) {
                        throw new IllegalArgumentException(illegalArgMsg);
                    }
                }
            }
//          Control ok
            this.grilleSudoku[x][y] = value;
        }
    }

    /**
     * Recupere une valeur de la grille Sudoku.
     * @param x
     * @param y
     * @return char aa
     * @throws IllegalArgumentException aa
     */
    @Override
    public final char getValue(final int x, final int y) 
            throws IllegalArgumentException {
//      test si x ou y sont hors bornes (0-8)
        if (x < 0 || x >= this.getDimension()
                || y < 0 || y >= this.getDimension()) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
        return this.grilleSudoku[x][y];
    }

    /**
     * Test si la grille est terminée.
     * @return true si ok
     */
    @Override
    public final boolean complete() {
//      Parcourir les lignes et colonnes pour detecter case VIDE
        for (int x = 0; x < this.getDimension(); x++) {
            for (int y = 0; y < this.getDimension(); y++) {
                if (this.grilleSudoku[x][y] == Grille.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Test si une valeur est possible dans la grille.
     * @param x
     * @param y
     * @param value
     * @return true rr
     * @throws IllegalArgumentException aa
     */
    @Override
    public final boolean possible(int x, int y, char value) 
            throws IllegalArgumentException {
//      test si x ou y sont hors bornes (0-8)
        if (x < 0 || x >= this.getDimension()
                || y < 0 || y >= this.getDimension()) {
            throw new IllegalArgumentException("Ligne ou colonne hors borne");
        }
//      Verifier que la valeur est compatible
        for (int i = 0; i < this.getDimension(); i++) {
            if (Grille.POSSIBLE[i] == value) {
                return true;
            }
        }
        return false;
    }

}
