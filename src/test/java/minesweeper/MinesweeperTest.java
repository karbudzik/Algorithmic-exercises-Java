package minesweeper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperTest {

    @Test
    public void should_throw_IllegalArgumentException_when_board_width_is_zero() {
        // given:
        Minesweeper minesweeper = new Minesweeper();

        // then:
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            minesweeper.generateEmptyArray(0, 5);
        });
    }

    @Test
    public void should_throw_IllegalArgumentException_when_board_height_is_zero() {
        // given:
        Minesweeper minesweeper = new Minesweeper();

        // then:
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            minesweeper.generateEmptyArray(5, 0);
        });
    }

    @Test
    public void should_properly_generate_empty_array_of_given_size() {
        // given:
        Minesweeper minesweeper = new Minesweeper();
        int width = 8;
        int height = 3;

        // when:
        String[][] board = minesweeper.generateEmptyArray(width, height);

        // then:
        assertEquals(height, board.length);
        assertEquals(width, board[0].length);
    }

    @Test
    public void should_fill_empty_array_with_dots() {
        // given:
        Minesweeper minesweeper = new Minesweeper();
        String EMPTY_FILED_CHAR = ".";
        int WIDTH = 3;
        int HEIGHT = 5;

        // when:
        String[][] board = minesweeper.generateEmptyArray(WIDTH, HEIGHT);
        String[] filteredBoardElements = Arrays.stream(board)
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(EMPTY_FILED_CHAR))
                .toArray(String[]::new);
        int expectedElementsNumber = WIDTH * HEIGHT;

        // then:
        assertEquals(expectedElementsNumber, filteredBoardElements.length);
    }

    @Test
    public void should_add_specified_number_of_mines() {
        // given:
        String[][] emptyBoard =  {{".", ".", "."}, {".", ".", "."}, {".", ".", "."}, {".", ".", "."}};
        Minesweeper minesweeper = new Minesweeper();
        String MINE_CHAR = "*";
        int NUMBER_OF_MINES = 4;

        // when:
        String[][] boardWithMines = minesweeper.addMinesRandomly(emptyBoard, NUMBER_OF_MINES);
        String[] minesArray = Arrays.stream(boardWithMines)
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(MINE_CHAR))
                .toArray(String[]::new);

        // then:
        assertEquals(NUMBER_OF_MINES, minesArray.length);
    }

    @Test
    public void should_throw_IllegalArgumentException_when_more_mines_than_elements_on_board() {
        // given:
        String[][] emptyBoard =  {{".", ".", "."}, {".", ".", "."}, {".", ".", "."}};
        Minesweeper minesweeper = new Minesweeper();
        int NUMBER_OF_MINES = 10;

        // then:
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            minesweeper.addMinesRandomly(emptyBoard, NUMBER_OF_MINES);
        });
    }

    @Test
    public void should_calculate_points_properly() {
        // given:
        String[][] boardWithMines = {{"*", "*", "*", "."}, {".", ".", ".", "."}, {".", ".", "*", "."}};
        Minesweeper minesweeper = new Minesweeper();
        String[] possibleNumbers = {"0", "1", "2", "3", "4"};
        int expectedAmountOfNumbers = 8;
        int expectedSumOfNumbers = 14;

        // when:
        String[][] boardWithMinesAndNumbers = minesweeper.addPointsToEmptyFields(boardWithMines);
        String[] numbersFromBoard = Arrays.stream(boardWithMinesAndNumbers)
                .flatMap(Arrays::stream)
                .filter(x -> Arrays.asList(possibleNumbers).contains(x))
                .toArray(String[]::new);
        int sumOfNumbers = Arrays.stream(numbersFromBoard)
                .mapToInt(Integer::parseInt)
                .reduce(0, Integer::sum);

        // then:
        assertEquals(expectedAmountOfNumbers, numbersFromBoard.length);
        assertEquals(expectedSumOfNumbers, sumOfNumbers);
    }
}