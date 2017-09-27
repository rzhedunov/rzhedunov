package ru.job4j.condition;

/**
 * Class Point 4.2.
 * @author rzhedunov
 * @since 2017-09-21
 * @version 4.2
 */

public class Point {
    /** Координата x точки. */
    private int x;
    /** Координата y точки. */
    private int y;

    /**
    * Method Point - constructor method.
    * @param x first number.
    * @param y second number.
    */
    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method getX - X-getter.
     * @return int.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Method getY - Y-getter.
     * @return int.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Method is checks if the point belongs to function a*x+b.
     * @param a the first function argument.
     * @param b the second function argument.
     * @return boolean.
     * The method works with a precision of 0.00001
     */
    public boolean is(int a, int b) {
        double differance = Math.abs(this.y - (a * this.x + b));
        return (differance < 0.00001);

    }
}

