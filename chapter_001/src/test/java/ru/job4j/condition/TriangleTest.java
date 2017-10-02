package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Class TriangleTest 4.3.
 * @author rzhedunov.
 * @since 2017-10-02.
 * @version 4.3.
 */

public class TriangleTest {
    /**
     * Method whenAreaSetThreePointsThenTriangleArea tests case when area was calculated right.
     */
    @Test
    public void whenAreaIsCalculatedRightThenTrue() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(4, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 6.099D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Method whenAreaIsNotCalculatedRightThenFalse tests case when area was not calculated right.
     */
    @Test
    public void whenAreaIsNotCalculatedRightThenFalse() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 3);
        Point c = new Point(4, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 6.101D;
        //Проверяем результат и ожидаемое значение.
        assertNotEquals(result, closeTo(expected, 0.1));
    }
}
