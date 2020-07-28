package minesweeper;

import java.util.Arrays;
import java.util.Random;

public class Minesweeper {

    public String[][] generateEmptyArray(int width, int height) {
        if (width != 0 && height != 0) {

            String[][] board = new String[height][width];

            for (String[] row : board) {
                for (int i = 0; i < width; i++) {
                    row[i] = ".";
                }
            }
            return board;
        } else {
            throw new IllegalArgumentException("Array dimensions need to be bigger than 0!");
        }
    }


    public String[][] addMinesRandomly(String[][] board, int numberOfMines) {
        try {
            int numberOfAllElements = board.length * board[0].length;
            if (numberOfMines >= numberOfAllElements) {
                throw new IllegalArgumentException("Number of mines need to be smaller than number of places on board!");
            }
            Random rand = new Random();
            int numberOfMinesLeft = numberOfMines;
            while (numberOfMinesLeft > 0) {
                int rowIndex = rand.nextInt(board.length);
                int columnIndex = rand.nextInt(board[0].length);
                if (board[rowIndex][columnIndex].equals(".")) {
                    board[rowIndex][columnIndex] = "*";
                    numberOfMinesLeft--;
                }
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Array dimensions need to be bigger than 0!");
        }

        return board;
    }

    public String[][] addPointsToEmptyFields(String[][] board) {

        for (String[] row : board) {
            for (int i = 0; i < board[0].length; i++) {
                int points = 0;
                int[][] coordinatesToCheck =  {{-1, -1}, {-1, 0}, {}, {}, {}, {}, {}, {}};

                // jeśli * to nie ruszamy
                row[i] = ".";
            }
        }
        return board;
    }

    public void printBoard(String[][] board) {
        Arrays.stream(board)
                .forEach(row -> {
                            Arrays.stream(row)
                                    .forEach((el) -> System.out.print(" " + el + " "));
                            System.out.print('\n');
                        }
                );
    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        String[][] board = minesweeper.generateEmptyArray(4, 5);
        String[][] boardWithMines = minesweeper.addMinesRandomly(board, 8);
        String[][] boardWithMinesAndPoints = minesweeper.addPointsToEmptyFields(boardWithMines);
        minesweeper.printBoard(boardWithMinesAndPoints);
    }
}
