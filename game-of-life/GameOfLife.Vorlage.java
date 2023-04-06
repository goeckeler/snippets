import java.util.Scanner;

/**
 * Simple simulation for the "Game of Life"
 * @author  	Professoren der Informatikfakultät
 * @version     1.0
 * Created on 	    20.3.2017, Wolfgang Mühlbauer
 * Modified	        20.3.2020, Silke Lechner-Greite
 */
public class GameOfLife {

    /**
     * prints living cells to console. Living cells are marked as "X", dead cells as "O".
     * @param c array of cells. True denotes living cells.
     */
    private static void printCells(boolean[][] c) {

        // TODO: implement

    }

    /**
     * count number of neighboring cells that are alife 
     * @param c 2-dimensional boolean array of cells (true means that cell is alife)
     * @param x row of considered cell
     * @param y column of considered cell
     * @return number of living cells that are neighbors to cell c[x][y]
     */
    private static int countLivingNeighbors(boolean[][] c, int x, int y) {


        // TODO: implement

        return 0;
    }

    /**
     * compute next iteration / next generation of cells based on given rules
     * @param cells current generation: 2-dimensional boolean array of cells (true means that cell is alife)
     * @return next generation, same representation as 2-dimensional array of cells
     */
    private static boolean[][] computeNextGenCells(boolean[][] cells) {


        // TODO: implement


        return null;
    }


	/**
	 * main-Methode welche das Javaprogramm ausführt.
	 * @param args input param - String array
	 */
    public static void main(String[] args) {

        // world consists of 10 x 10 elements
        boolean[][] cells = new boolean[10][10];




        // TODO: initiales 2-dim array "cells"; likelihood shall be 50% that a cell is marked as alife




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
}