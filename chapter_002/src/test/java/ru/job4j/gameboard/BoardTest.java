package ru.job4j.gameboard;

import org.junit.Test;

/**
 * Class BoardTest 002.8.1.
 *
 * @author rzhedunov.
 * @version 002.8.1.
 * @since 2018-03-30.
 */

public class BoardTest {
    Board board = new Board();

    /**
     * Method whenAddFigureToTheSameCellThenThrowsException tests exception raising when add two figures to the same cell.
     */
    @Test(expected = ImpossibleToAddFigure.class)
    public void whenAddFigureToTheSameCellThenThrowsException() throws ImpossibleToAddFigure {
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.add(bishop);
        Bishop bishop2 = new Bishop(new Cell(1, 1));
        board.add(bishop2);
    }

    /**
     * Method whenMovesFromTheEmptyCellThenThrowsException tests exception raising when moving not existing figure .
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenMovesFromTheEmptyCellThenThrowsException() throws Exception {
        this.board.move(new Cell(2, 2), new Cell(3, 3));
    }

    /**
     * Method whenDestinationCellIsBusyThenThrowsException tests exception raising when destination cell is busy.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenDestinationCellIsBusyThenThrowsException()
            throws ImpossibleMoveException, ImpossibleToAddFigure, OccupiedWayException, FigureNotFoundException,
            FigureWasNotMoved {
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.add(bishop);
        Bishop bishop2 = new Bishop(new Cell(2, 2));
        board.add(bishop2);
        board.move(bishop.position, new Cell(2, 2));
    }



    /**
     * Method whenTheWayIsBusyThenThrowsException tests exception raising when moving through another figure .
     */
    @Test(expected = OccupiedWayException.class)
    public void whenTheWayIsBusyThenThrowsException() throws Exception {
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.add(bishop);
        Bishop bishop2 = new Bishop(new Cell(2, 2));
        board.add(bishop2);

        this.board.move(new Cell(1, 1), new Cell(3, 3));
    }

}
