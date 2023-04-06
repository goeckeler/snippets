package game;

import java.util.Scanner;

/**
 * Simple simulation for the "Game of Life"
 * @author  	Professoren der Informatikfakultät
 * @version     1.0
 * Created on 	    20.3.2017, Wolfgang Mühlbauer
 * Modified	        20.3.2020, Silke Lechner-Greite
 */
public class GameOfLife {
    private static String[] LINE = {
        ".X.",
        ".X.",
        ".X."
    };

    /**
     * prints living cells to console. Living cells are marked as "X", dead cells as "O".
     * @param c array of cells. True denotes living cells.
     */
    private static void printCells(boolean[][] c) {
        if (c == null) {
            System.out.println("");
            return;
        }

        StringBuilder string = new StringBuilder();
        for (int row = 0; row < c.length; ++row) {
          for (int col = 0; col < c[row].length; ++col) {
            string.append(c[row][col] ? 'X' : ' ');
          }
          string.append('\n');
        }
        System.out.println(string.toString());
    }

    /**
     * count number of neighboring cells that are alife 
     * @param c 2-dimensional boolean array of cells (true means that cell is alife)
     * @param x row of considered cell
     * @param y column of considered cell
     * @return number of living cells that are neighbors to cell c[x][y]
     */
    private static int countLivingNeighbors(boolean[][] c, int x, int y) {
        int alive = 0;
        for (int row = Math.max(0, x-1); row < Math.min(c.length, x+1); ++row) {
          for (int col = Math.max(0, y-1); col < Math.min(c[row].length, y+1); ++col) {
            if (row == x && col == y) continue;
            alive += c[row][col] ? 1 : 0;
          }
        }
 
        return alive;
    }

    /**
     * compute next iteration / next generation of cells based on given rule
     * @param cells current generation: 2-dimensional boolean array of cells (true means that cell is alife)
     * @return next generation, same representation as 2-dimensional array of cells
     */
    private static boolean[][] computeNextGenCells(boolean[][] cells) {
        // there are three options, a final flat world, a folded world, and an endless world
        // to keep this very simple we assume a final flat world like an island
       
        boolean[][] next = new boolean[cells.length][cells[0].length];

        /*
         * 1. Lebende Zellen mit weniger als 2 lebenden Nachbarn
         * sterben in der Folgegeneration an Einsamkeit.
         * 2. Lebende Zellen mit mehr als 3 lebenden Nachbarn
         * sterben in der Folgegeneration an Überbevölkerung.
         * 3. Lebende Zellen mit 2 oder 3 lebenden Nachbarn bleibt
         * in der Folgegeneration am Leben.
         * 4. Eine tote Zelle mit genau 3 lebenden Nachbarn wird
         * in der nächsten Generation neugeboren.
         */
        for (int row = 0; row < cells.length; ++row) {
            for (int col = 0; col < cells[row].length; ++col) {
                int alive = countLivingNeighbors(cells, row, col);
                if (alive < 2 || alive > 3) {
                    next[row][col] = false;
                } else if (alive == 3) {
                    next[row][col] = true;
                } else {
                    next[row][col] = cells[row][col];
                }
            }
        }    

        return next;
    }


	/**
	 * main-Methode welche das Javaprogramm ausführt.
	 * @param args input param - String array
	 */
    public static void main(String[] args) {

        // world consists of 10 x 10 elements
        boolean[][] cells = presetGeneration(LINE);

        // print out first generation
        System.out.println("Generation #1");
        printCells(cells);

        Scanner scanner = new Scanner(System.in);
        int i = 1;
        do {
            cells = computeNextGenCells(cells);
            System.out.println("Generation #:" + (++i));
            printCells(cells);
            System.out.println("Should I compute another generation? 'y' for \"yes\"");
        } while (scanner.next().equals("y"));


        System.out.println("Terminating");
    }

    private static boolean[][] randomGeneration() {
         // world consists of 10 x 10 elements
         boolean[][] cells = new boolean[10][10];

         // initiales 2-dim array "cells"; likelihood shall be 50% that a cell is marked as alife
         for (int row = 0; row < cells.length; ++row) {
             for (int col = 0; col < cells[row].length; ++col) {
               cells[row][col] = (Math.random() < 0.5);
             }
         }               
         
         return cells;
    }

    private static boolean[][] presetGeneration(String[] pattern) {
        boolean[][] cells = new boolean[pattern.length][pattern[0].length()];
        for (int row = 0; row < cells.length; ++row) {
            for (int col = 0; col < cells[row].length; ++col) {
                cells[row][col] = pattern[row].substring(col, col+1).equals("X");
            }
        }
        return cells;
   }
}
