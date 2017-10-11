package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class RotateArrayTest  6.2.
 * @author rzhedunov.
 * @since 2017-10-11.
 * @version 6.2
 */

public class RotateArrayTest {

    /**
     * Method whenRotateTwoRowTwoColArrayThenRotatedArray tests the rotation of the array 2x2 given.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        int[][] a = {{1, 2}, {3, 4}};
        RotateArray rotateArray = new RotateArray();
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(rotateArray.rotate(a), is(expected));
    }

    /**
     * Method whenRotateThreeRowThreeColArrayThenRotatedArray tests the rotation of the array 3x3 given.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateArray rotateArray = new RotateArray();
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(rotateArray.rotate(a), is(expected));
    }
}

