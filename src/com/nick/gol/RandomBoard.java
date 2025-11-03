
package com.nick.gol;

import java.util.Random;

public class RandomBoard extends GameBoard{
    // This class has been removed and is no longer in use.
    public RandomBoard(int width, int height) {
        super(width, height);
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(5, 20); i++) {
            int x = rand.nextInt(0, width - 1);
            int y = rand.nextInt(0, height - 1);
            this.setCell(x, y, true);
        }

    }


    @Override
    public void printBoard() {
        for (int idx = 0; idx < this.height; idx++) {
            for (int idy = 0; idy < this.width; idy++) {
                if (this.getCell(idx, idy).getIsAlive()) {
                    System.out.print("▲ ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }
}