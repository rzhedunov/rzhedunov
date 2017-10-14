package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class MergeArraysTest 7.0.
 * @author rzhedunov.
 * @since 2017-10-14.
 * @version 7.0
 */

public class MergeArraysTest {
    /**
     * Method whenLengthOfMergedArraysAreTheSameThenArrayOfDoubledLength tests the merge of arrays with the same length.
     */
    @Test
    public void whenLengthsOfMergedArraysAreTheSameThenArray() {
        int[] array1 = {10, 20, 30};
        int[] array2 = {15, 18, 21};

        MergeArrays mergeArrays = new MergeArrays();
        int[] mergedArray = mergeArrays.merge(array1, array2);

        int[] expected =  {10, 15, 18, 20, 21, 30};
        assertThat(mergedArray, is(expected));
    }

    /**
     * Method whenFirstOfTwoMergedArraysIsLongerThenArray tests the merge of a long and a short arrays.
     */
    @Test
    public void whenFirstOfTwoMergedArraysIsLongerThenArray() {
        int[] array1 = {0, 10, 20, 30};
        int[] array2 = {15, 18, 21};

        MergeArrays mergeArrays = new MergeArrays();
        int[] mergedArray = mergeArrays.merge(array1, array2);

        int[] expected =  {0, 10, 15, 18, 20, 21, 30};
        assertThat(mergedArray, is(expected));
    }
    /**
     * Method whenSecondOfTwoMergedArraysIsLongerThenArray tests the merge of a short and a long arrays.
     */
    @Test
    public void whenSecondOfTwoMergedArraysIsLongerThenArray() {
        int[] array1 = {15, 18, 21};
        int[] array2 = {0, 10, 20, 30};

        MergeArrays mergeArrays = new MergeArrays();
        int[] mergedArray = mergeArrays.merge(array1, array2);

        int[] expected =  {0, 10, 15, 18, 20, 21, 30};
        assertThat(mergedArray, is(expected));
    }
}
