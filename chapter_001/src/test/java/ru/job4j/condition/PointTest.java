package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class PointTest 4.2.
 * @author rzhedunov.
 * @since 2017-09-27.
 * @version 4.2.
 */
public class PointTest {
    /**
     * Method whenPointBelongsToFunctionThenTrue tests case when point belongs to function.
     */
    @Test
    public void whenPointBelongsToFunctionThenTrue() {
        Point point = new Point(1, 2);
        assertThat(point.is(1, 1), is(true));
    }

    /**
     * Method whenPointDoesNotBelongToFunctionThenFalse tests case when point does not belong to function.
     */
    @Test
    public void whenPointDoesNotBelongToFunctionThenFalse() {
        Point point = new Point(1, 1);

        assertThat(point.is(1, 1), is(false));
    }


}