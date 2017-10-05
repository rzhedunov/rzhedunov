package ru.job4j.loop;

/**
 * Class Counter 5.1.
 * @author rzhedunov
 * @since 2017-10-05
 * @version 5.1
 */

public class Counter {

    /**
     * Method add(int start, int finish) returns the sum of even numbers from range given.
     * @param start is the first number of the range
     * @param finish is the last number of the range
     * @return int
     */

    public int add(int start, int finish) {
        int sum = 0;
        for (int x = start; x <= finish; x++) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        return sum;
    }
}
