package ru.job4j.gameboard;

/**
 * Class ImpossibleMoveException 002.8.1.
 */
class ImpossibleMoveException extends Exception {
    ImpossibleMoveException() {
    }

    public String toString() {
        return "ImpossibleMoveException!";
    }
}

/**
 * Class ImpossibleToAddFigure 002.8.1.
 */
class ImpossibleToAddFigure extends Exception {
    ImpossibleToAddFigure() {
    }

    public String toString() {
        return "ImpossibleToAddFigure!";
    }
}

/**
 * Class OccupiedWayException 002.8.1.
 */
class OccupiedWayException extends Exception {
    OccupiedWayException() {
    }

    public String toString() {
        return "OccupiedWayException!";
    }
}

/**
 * Class FigureNotFoundException 002.8.1.
 */
class FigureNotFoundException extends Exception {
    FigureNotFoundException() {
    }

    public String toString() {
        return "FigureNotFoundException!";
    }
}

/**
 * Class FigureWasNotMoved 002.8.1.
 */
//Если после всех проверок фигуру всё-таки не удалось передвинуть
class FigureWasNotMoved extends Exception {
    FigureWasNotMoved() {
    }

    public String toString() {
        return "FigureWasNotMoved!";
    }
}

/**
 * Class GameBoardExceptions 002.8.1.
 *
 * @author rzhedunov
 * @version 002.8.1.
 * @since 2018-03-30
 */
public class GameBoardExceptions {

}
