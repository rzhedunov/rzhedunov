package ru.job4j.max;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class MaxTest 4.1.
 * @author rzhedunov.
 * @since 2017-09-21.
 * @version 4.1.
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
     * Method whenNumbersAreEqual tests result when numbers are equal.
     */
    @Test
    public void whenNumbersAreEqual() {
        Max maxim = new Max();
        int result = maxim.max(1, 1);
        assertThat(result, is(1));
    }

}
