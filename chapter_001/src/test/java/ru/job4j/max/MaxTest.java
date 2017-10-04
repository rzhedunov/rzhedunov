package ru.job4j.max;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class MaxTest 4.1.2.
 * @author rzhedunov.
 * @since 2017-09-21.
 * @version 4.1.2.
 */

public class MaxTest {
    /**
     * Method whenFirstLessSecond tests result when first is less.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Method whenSecondLessFirst tests result when second is less.
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }

    /**
     * Method whenTwoNumbersAreEqual tests result when numbers are equal.
     */
    @Test
    public void whenTwoNumbersAreEqual() {
        Max maxim = new Max();
        int result = maxim.max(1, 1);
        assertThat(result, is(1));
    }

    /**
     * Method whenThreeNumbersAreEqual tests result when three numbers are equal.
     */
    @Test
    public void whenThreeNumbersAreEqual() {
        Max maxim = new Max();
        int result = maxim.max(1, 1, 1);
        assertThat(result, is(1));
    }

    /**
     * Method whenThreeNumbersAreNotEqual tests result when three numbers are not equal.
     */
    @Test
    public void whenThreeNumbersAreNotEqual() {
        Max maxim = new Max();
        int result = maxim.max(2, 1, 1);
        assertThat(result, is(2));
        result = maxim.max(1, 3, 1);
        assertThat(result, is(3));
        result = maxim.max(1, 1, 4);
        assertThat(result, is(4));
    }
}
