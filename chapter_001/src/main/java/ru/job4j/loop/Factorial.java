package ru.job4j.loop;

/**
 * Class Factorial 5.2.
 * @author rzhedunov
 * @since 2017-10-05
 * @version 5.2
 */

public class Factorial {

    /**
     * Method calc(int n) returns the factorial of a number given.
     * @param n is the first number of the range
     * @return int
     */

    public int calc(int n) {
        int factorial = 1;
        if (n > 1) {
            factorial = (n * this.calc(n - 1));
        }
        return factorial;
    }
}

