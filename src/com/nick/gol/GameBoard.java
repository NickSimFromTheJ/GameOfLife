package com.nick.gol;

/**
 * Represents the Game of Life board as a flat array of {@link Cell} objects.
 *
 * The board is indexed by row (x) and column (y). Cells are stored in a
 * one-dimensional array using row-major order: index = row * width + col.
 */
public class GameBoard {

    /** Number of columns (width). */
    int width, height;
    /** Flat array of cells in row-major order (row * width + col). */
    Cell cells[];

    /**
     * Create a new empty board of the given dimensions.
     *
     * @param width  number of columns
     * @param height number of rows
     */
    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[width * height];
        for (int idx = 0; idx < this.height; idx++) {
            for (int idy = 0; idy < this.width; idy++) {
                cells[idx * width + idy] = new Cell(idx, idy, false);
            }
        }
    }

    /**
     * Return the cell at the given row (x) and column (y).
     *
     * Note: x is the row (0..height-1) and y is the column (0..width-1).
     *
     * @param x row index
     * @param y column index
     * @return Cell at (x, y)
     */
    public Cell getCell(int x, int y) {
        assert(x >= 0 && x < this.height);
        assert(y >= 0 && y < this.width);

        return cells[x * this.width + y];
    }

    /**
     * Set the alive state of the cell at (x, y).
     *
     * @param x row index
     * @param y column index
     * @param isAlive desired alive state
     */
    public void setCell(int x, int y, boolean isAlive) {
        cells[x * this.width + y].setIsAlive(isAlive);
    }

    /**
     * Compute next state for all cells, then apply the updates so the board
     * advances one generation.
     */
    public void updateState() {
        for (Cell c: cells) {
            c.updateState(this);
        }
        for (Cell c: cells) {
            c.applyUpdate();
        }
    }

    /**
     * Print the board to standard output. Rows are printed top-to-bottom.
     */
    public void printBoard() {
        for (int idx = 0; idx < this.height; idx++) {
            for (int idy = 0; idy < this.width; idy++) {
                System.out.print(this.getCell(idx, idy).toString() + " " );
            }
            System.out.println("");
        }
    }

}