package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class BoardTest 5.3.
 * @author rzhedunov.
 * @since 2017-10-06.
 * @version 5.3.
 */
public class BoardTest {
    /**
     * Method whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows tests board 3x3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }

    /**
     * Method whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows tests board 5x4.
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}