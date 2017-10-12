package ru.job4j.array;

import java.util.Arrays;

/**
 * Class ArrayDuplicate 6.3.
 * @author rzhedunov
 * @since 2017-10-12
 * @version 6.3
 */

public class ArrayDuplicate {
    /**
     * Method remove(String[] array) returns the array given without duplicates.
     * @param array is the array given
     * @return String[]
     */
    public String[] remove(String[] array) {
        int duplicateStartPosition = array.length;
        for (int i = 0; i < duplicateStartPosition; i++) {
            for (int j = i + 1; j < duplicateStartPosition; j++) {
                while (array[i].equals(array[j]) && (j < duplicateStartPosition)) {
                    duplicateStartPosition--;
                    String temp = array[j];
                    array[j] = array[duplicateStartPosition];
                    array[duplicateStartPosition] = temp;
                }
            }
        }
        return Arrays.copyOf(array, duplicateStartPosition);
    }
}
