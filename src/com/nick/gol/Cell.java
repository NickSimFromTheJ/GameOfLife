package com.nick.gol;

/**
 * Represents a single cell in Conway's Game of Life.
 *
 * Coordinates: x = row index (0-based), y = column index (0-based).
 * The `nextIsAlive` field stores the computed state for the next generation so
 * that the whole board can be updated simultaneously.
 */
public class Cell {
    /** Row index of this cell (0-based). */
    private int x, y;
    /** Current alive state of the cell. */
    private boolean isAlive;
    /** Computed state for the next generation. */
    private boolean nextIsAlive;
    /**
     * Construct a Cell at coordinates (x, y).
     *
     * @param x row index (0-based)
     * @param y column index (0-based)
     * @param isAlive initial alive state
     */
    Cell(int x, int y, boolean isAlive ) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
        this.nextIsAlive = isAlive;
    }

    /** Set the row index for this cell. */
    public void setX(int x) { this.x = x; }
    /** Set the column index for this cell. */
    public void setY(int y) { this.y = y; }
    /** Set whether this cell is currently alive. */
    public void setIsAlive(boolean isAlive) { this.isAlive = isAlive; }

    /** Get row index. */
    public int getX() { return x; }
    /** Get column index. */
    public int getY() { return y; }
    /** Get current alive state. */
    public boolean getIsAlive() { return isAlive; }


    /**
     * Count alive neighbors around this cell.
     *
     * The method checks the 8 surrounding cells and performs bounds checks
     * against the provided board to avoid out-of-range accesses.
     *
     * @param board the GameBoard containing cells
     * @return number of alive neighboring cells (0..8)
     */
    public int neighborCount(GameBoard board) {
        int count = 0;
        
        if (x > 0) {
            if (board.getCell(x-1, y).isAlive) { count++; }
        }
        if ( x + 1 < board.width) {
            if (board.getCell(x+1, y).isAlive) { count++ ; }
        }
        if (y > 0) {
            if (board.getCell(x, y-1).isAlive) { count++; }
        }
        if (y + 1 < board.height) {
            if (board.getCell(x, y+1).isAlive) { count++ ; }
        }
        if (x > 0 && y > 0) {
            if (board.getCell(x-1, y-1).isAlive) { count++; }
        }
        if (x + 1 < board.width && y > 0 ) {
            if (board.getCell(x+1, y-1).isAlive) { count++ ; }
        }
        if (x > 0 && y + 1 < board.height) {
            if (board.getCell(x-1, y+1).isAlive) { count++; }
        }
        if (x + 1 < board.width && y + 1 < board.height) {
            if (board.getCell(x+1, y+1).isAlive) { count++ ; }
        }
        return count;
    }

    /**
     * Compute the next alive state for this cell based on current neighbors.
     * The result is stored in {@link #nextIsAlive} and must be applied later
     * via {@link #applyUpdate()} to take effect for the board.
     *
     * @param board the current game board
     */
    public void updateState(GameBoard board) {
        int n = neighborCount(board);
        if (this.isAlive && n < 2) {
            this.nextIsAlive = false;
        }
        if (this.isAlive && (n == 2 || n == 3)) {
            this.nextIsAlive = true;
        }
        if (this.isAlive && n > 3) {
            this.nextIsAlive = false;
        }
        if (!this.isAlive && n == 3) {
            this.nextIsAlive = true;
        }
    }

    /** Apply the previously computed next state to become the current state. */
    public void applyUpdate() {
        this.isAlive = this.nextIsAlive;
    }

    @Override
    public String toString() {
        return (this.isAlive) ? "■" : " ";
    }
    

}