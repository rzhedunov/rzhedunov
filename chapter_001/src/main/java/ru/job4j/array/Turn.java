package ru.job4j.array;


/**
 * Class Turn 6.0.
 * @author rzhedunov
 * @since 2017-10-07
 * @version 6.0
 */
public class Turn {

    /**
     * Method back(int[] array) returns the reversed array.
     * @param array is the array given
     * @return int[]
     */
    public int[] back(int[] array) {
        int temp = -1;
        int arrayLenght = array.length;
        for (int i = 0; i < arrayLenght / 2; i++) {
            temp = array[i];
            array[i] = array[arrayLenght - i - 1];
            array[arrayLenght - i - 1] = temp;
        }
        return array;
    }
}
