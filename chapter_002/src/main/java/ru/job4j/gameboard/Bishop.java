package ru.job4j.gameboard;

/**
 * Class Bishop 002.8.1.
 *
 * @author rzhedunov
 * @version 002.8.1.
 * @since 2018-03-26
 */

public class Bishop extends Figure {


    /**
     * Конструктор для добавления слона.
     *
     * @param cell начальное поле слона.
     */
    Bishop(Cell cell) {
        super(cell);
    }

    /**
     * Метод для копирования фигуры.
     *
     * @param dest ячейка для размещения фигуры.
     */
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    /**
     * Метод определения траектории хода слона.
     *
     * @param source начальное поле слона.
     * @param dest   поле назначения.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(dest.h - source.h) != Math.abs(dest.v - source.v)) {
            throw (new ImpossibleMoveException());
        } else {
            int cellsCount = Math.abs(source.h - dest.h) + 1;
            Cell[] cells = new Cell[cellsCount];
            int stepH = (dest.h - source.h > 0) ? 1 : -1;
            int stepV = (dest.v - source.v > 0) ? 1 : -1;

            //начальное и конечное поле включаются в траекторию
            for (int i = 0; i < cellsCount; i++) {
                cells[i] = new Cell(source.h + stepH, source.v + stepV);
            }
            return cells;
        }
    }
}
