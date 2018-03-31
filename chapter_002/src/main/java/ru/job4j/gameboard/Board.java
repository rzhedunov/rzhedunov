package ru.job4j.gameboard;

public class Board {
    /**
     * Массив фигур доски
     */
    public Figure[] figures = new Figure[32];

    /**
     * Метод для добавления фигуры.
     *
     * @param figure добавляемая фигура.
     */
    public boolean add(Figure figure) throws ImpossibleToAddFigure {
        for (int i = 0; i < 32; i++) {
            if (figures[i] != null) {
                if ((figures[i].position.h == figure.position.h) && (figures[i].position.v == figure.position.v)) {
                    throw new ImpossibleToAddFigure();
                }
            }
        }
        int lastFigure = -1;
        for (int i = 0; i < 32; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                lastFigure = i;
                break;
            }
        }
        if (lastFigure == -1) {
            throw (new ImpossibleToAddFigure());
        }
        return true;
    }

    /**
     * Метод для выполнения хода фигурой.
     *
     * @param source исходное поле.
     * @param dest   поле назначения.
     */
    public boolean move(Cell source, Cell dest)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException, FigureWasNotMoved {
        //Проверка, есть ли в исходном поле какая-нибудь фигура? если да - запоминаем какая
        Figure figureSource = null;
        int positionInArrayOfFigures = -1;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null) {
                if ((figures[i].position.h == source.h) && (figures[i].position.v == source.v)) {
                    figureSource = figures[i];
                }
            }
        }
        if (figureSource == null) {
            throw (new FigureNotFoundException());
        }

        //Проверка, свободно ли конечное поле
        boolean empty = true;
        for (Figure figure : figures) {
            if (figure != null) {
                if ((figure.position.h == dest.h) && (figure.position.v == dest.v)) {
                    empty = false;
                }
            }
        }
        if (!empty) {
            throw (new ImpossibleMoveException());
        }

        //Проверка, свободен ли проход между исходным и конечным полем
        boolean emptyWay = true;
        //Узнать, что за фигура в поле source

        for (Figure figure : figures) {
            if (figure != null) {
                for (Cell cell : figureSource.way(source, dest)) {
                    if ((figure.position.h == cell.h) && (figure.position.v == cell.v)) {
                        emptyWay = false;
                    }
                }
            }
        }
        if (!emptyWay) {
            throw (new OccupiedWayException());
        }

        //Создаем копию фигуры с новой позицией
        Figure figureDest = figureSource.copy(dest);
        //освобождаем прежнее место в массиве фигур
        this.figures[positionInArrayOfFigures] = null;
        try {
            this.add(figureDest);
            figureSource = null;
        } catch (Exception e) {
            figureDest = null;
            this.figures[positionInArrayOfFigures] = figureSource;
            throw (new FigureWasNotMoved());
        }
        return true;
    }
}
