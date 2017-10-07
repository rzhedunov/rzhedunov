package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class TurnTest 6.0.
 * @author rzhedunov.
 * @since 2017-10-07.
 * @version 6.0
 */
public class TurnTest {
    /**
     * Method whenTurnArrayWithEvenAmountOfElementsThenTurnedArray tests array of even number of elements.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        int[] a = {2, 6, 1, 4};
        Turn turn = new Turn();
        int[] expected = {4, 1, 6, 2};
        assertThat(turn.back(a), is(expected));
    }

    /**
     * Method whenTurnArrayWithOddAmountOfElementsThenTurnedArray tests array of odd number of elements.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        int[] a = {1, 2, 3, 4, 5};
        Turn turn = new Turn();
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(turn.back(a), is(expected));
    }
}
