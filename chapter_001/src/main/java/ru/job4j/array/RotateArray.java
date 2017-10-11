package ru.job4j.array;

/**
 * Class RotateArray 6.2.
 * @author rzhedunov
 * @since 2017-10-11
 * @version 6.2
 */
public class RotateArray {
    /**
     * Method rotate(int[][] array) returns the clockwise turned array.
     * @param array is the array given
     * @return int[][]
     */
    public int[][] rotate(int[][] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j <= n - i - 2; j++) {
                temp = array[i][j];
                array[i][j] = array[n - 1 - j][i];
                array[n - 1 - j][i] = array[n - 1 - i][n - 1 - j];
                array[n - 1 - i][n - 1 - j] = array[j][n - 1 - i];
                array[j][n - 1 - i] = temp;
            }
        }
        return array;
    }
}
