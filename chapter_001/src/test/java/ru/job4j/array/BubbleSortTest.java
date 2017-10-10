package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class BubbleSortTest 6.1.
 * @author rzhedunov.
 * @since 2017-10-09.
 * @version 6.1
 */

public class BubbleSortTest {
    /**
     * Method whenSortArrayWithTenElementsThenSortedArray tests the sortition of the array given.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] a = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        BubbleSort bubbleSort = new BubbleSort();
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(bubbleSort.sort(a), is(expected));
    }
}
