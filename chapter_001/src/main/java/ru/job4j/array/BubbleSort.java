package ru.job4j.array;

/**
 * Class Turn 6.1.
 * @author rzhedunov
 * @since 2017-10-09
 * @version 6.1
 */

class BubbleSort {
    /**
     * Method sort(int[] array) returns the sorted array.
     * @param array is the array given
     * @return int[]
     */
    int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
