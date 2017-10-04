package ru.job4j.max;

/**
 * Class Max 4.1.2.
 * @author rzhedunov.
 * @since 2017-09-21.
 * @version 4.1.2.
 */
public class Max {
    /**
     * Method max(int first, int second) returns the biggest of two numbers given.
     * @param first is the first number
     * @param second is the second number
     * @return int
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Method max(int first, int second, int third) returns the biggest of three numbers given.
     * @param first is the first number
     * @param second is the second number
     * @param third is the third number
     * @return int
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
