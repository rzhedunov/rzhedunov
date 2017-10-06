package ru.job4j.loop;

/**
 * Class Board 5.3.
 * @author rzhedunov
 * @since 2017-10-06
 * @version 5.3
 */

public class Board {
    /**
     * Method paint(int width, int height) returns the board in a string format.
     * @param width is the width of the board
     * @param height is the height of the board
     * @return String
     */

    public String paint(int width, int height) {
        StringBuilder builder = new StringBuilder();
        final String lineSeparator = System.getProperty("line.separator");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                builder.append((((i + j) % 2) == 0) ? 'x' : ' ');
            }
            builder.append(lineSeparator);
        }
        return builder.toString();
    }
}
