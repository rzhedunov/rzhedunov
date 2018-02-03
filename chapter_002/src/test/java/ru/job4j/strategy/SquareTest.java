package ru.job4j.strategy;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SquareTest 002.4.4.
 * @author rzhedunov.
 * @since 2018-02-03.
 * @version 002.4.4.
 */
public class SquareTest {
    /**
     * Method whenDrawSquareThenReturnsSquare tests drawing the square.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .toString()
                )
        );
    }

}


