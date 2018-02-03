package ru.job4j.strategy;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Class TriangleTest 002.4.4.
 * @author rzhedunov.
 * @since 2018-02-03.
 * @version 002.4.4.
 */
public class TriangleTest {
    /**
     * Method whenDrawTriangleThenReturnsTriangle tests drawing the triangle.
     */
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("+")
                                .append("++")
                                .append("+ +")
                                .append("++++")
                                .toString()
                )
        );
    }

}
