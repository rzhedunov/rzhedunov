package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class CounterTest 5.1.
 * @author rzhedunov.
 * @since 2017-10-05.
 * @version 5.1.
 */
public class CounterTest {
    /**
     * Method whenDirectCycleThenResult tests case when cycle runs from 0 to 10.
     */
    @Test
    public void whenDirectCycleThenResult() {
        Counter counter = new Counter();
        assertThat(counter.add(0, 10), is(30));
    }

    /**
     * Method whenReverseCycleThenZero tests case when cycle runs from 10 to 0.
     */
    @Test
    public void whenReverseCycleThenZero() {
        Counter counter = new Counter();
        assertThat(counter.add(10, 0), is(0));
    }

}