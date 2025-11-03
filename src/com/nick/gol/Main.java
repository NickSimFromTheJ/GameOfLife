package com.nick.gol;

/**
 * Demo runner for the Game of Life board. This class initializes a small
 * pattern and steps the board several generations, printing each generation
 * to standard output.
 */
public class Main {
    /**
     * Entry point for the demo.
     *
     * @param args unused
     */
    public static void main(String args[]) {
        try {
            GameBoard board = new GameBoard(15, 15);
            board.setCell(5, 5, true);
            board.setCell(5, 6, true);
            board.setCell(6, 5, true);
            board.setCell(6, 6, true);

            board.setCell(7, 7, true);
            board.setCell(8, 7, true);
            board.setCell(7, 8, true);
            board.setCell(8, 8, true);

            while (true) {
                board.printBoard();
                board.updateState();

                Thread.sleep(200); 
                System.out.print("\033[H\033[2J");

                final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}