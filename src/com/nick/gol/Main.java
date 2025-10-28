package com.nick.gol;

public class Main {
    public static void main(String args[]) {
        try {
                GameBoard board = new GameBoard(15, 15);
            // board.setCell(10, 10, true);
            // board.setCell(10, 11, true);
            // board.setCell(11, 10, true);
            // board.setCell(11, 11, true);
            // board.setCell(9, 9, true);
            // board.setCell(9, 8, true);
            // board.setCell(8, 9, true);
            // board.setCell(8, 8, true);
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
                            board.setCell(10, 10, true);
                            board.setCell(10, 11, true);
                            board.setCell(11, 10, true);
                            board.setCell(11, 11, true);
                            board.setCell(9, 9, true);
                            board.setCell(9, 8, true);
                            board.setCell(8, 9, true);
                            board.setCell(8, 8, true);
                            for (int i = 0; i < 15; i++) {
                                board.printBoard();
                                board.updateState();

                                Thread.sleep(200); 
                                System.out.print("\033[H\033[2J");
                            }
                        } catch(Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                }
            for (int i = 0; i < 15; i++) {
                board.printBoard();
                board.updateState();

                
                Thread.sleep(200); 
                System.out.print("\033[H\033[2J");
                
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}