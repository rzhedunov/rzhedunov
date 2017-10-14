package ru.job4j.array;

/**
 * Class MergeArrays 7.0.
 * @author rzhedunov
 * @since 2017-10-14
 * @version 7.0
 */
public class MergeArrays {
    /**
     * Method merge(int[] array1, int[] array2) returns the array merged of two given arrays.
     * @param array1 is the first array given
     * @param array2 is the second array given
     * @return int[]
     */
    public int[] merge(int[] array1, int[] array2) {
        int resultArrayLenght = array1.length + array2.length;
        int[] array3 = new int[resultArrayLenght];

        int f1 = 0, f2 = 0, f3 = 0;
        while ((f1 < array1.length) && (f2 < array2.length)) {
            if (array1[f1] < array2[f2]) {
                array3[f3++] = array1[f1++];
            } else {
                array3[f3++] = array2[f2++];
            }
        }

        if (f1 == array1.length) {
            for (int i = f2; i < array2.length; i++) {
                array3[f3++] = array2[f2++];
            }
        } else {
            for (int i = f1; i < array1.length; i++) {
                array3[f3++] = array1[f1++];
            }
        }
        return array3;
    }




}
