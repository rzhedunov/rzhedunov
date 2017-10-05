package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class FactorialTest 5.2.
 * @author rzhedunov.
 * @since 2017-10-05.
 * @version 5.2
*/

public class FactorialTest {
    /**
     * Method whenArgumentIsZeroThenOne tests case when argument is 0.
     */
    @Test
    public void whenArgumentIsZeroThenOne() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(0), is(1));
    }

    /**
     * Method whenArgumentIsOneThenOne tests case when argument is 1.
     */
    @Test
    public void whenArgumentIsOneThenOne() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(1), is(1));
    }

    /**
     * Method whenArgumentIsTwoOrMoreThenOne tests case when argument is 2 or more.
     */
    @Test
    public void whenArgumentIsTwoOrMOre() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(2), is(2));
    }

    /**
     * Method whenArgumentIsNegativeThenOne tests case when argument is negative.
     */
    @Test
    public void whenArgumentIsNegativeThenOne() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(-1), is(1));
    }
}

