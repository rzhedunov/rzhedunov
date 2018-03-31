package ru.job4j.gameboard;

/**
 * Class Cell 002.8.1.
 *
 * @author rzhedunov
 * @version 002.8.1.
 * @since 2018-03-23
 */
class Cell {
    /**
     * Координата ячейки по горизонтали
     */
    public int h;
    /**
     * Координата ячейки по вертикали
     */
    public int v;

    public Cell(int h, int v) {
        this.h = h;
        this.v = v;
    }
}

/**
 * Class Figure 002.8.1.
 *
 * @author rzhedunov
 * @version 002.8.1.
 * @since 2018-03-23
 */
public abstract class Figure {
    /**
     * Координата фигуры
     */
    final Cell position;

    /**
     * Конструктор для добавления фигуры.
     *
     * @param cell начальное поле фигуры.
     */
    Figure(Cell cell) {
        this.position = cell;
    }

    /**
     * Метод определения траектории хода фигурой.
     *
     * @param source начальное поле фигуры.
     * @param dest   поле назначения.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        return null;
    }

    /**
     * Метод создания копии текущей фигуры в новой ячейке.
     *
     * @param dest поле назначения.
     */
    abstract Figure copy(Cell dest);
}
