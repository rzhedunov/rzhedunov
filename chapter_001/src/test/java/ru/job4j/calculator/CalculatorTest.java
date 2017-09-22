package ru.job4j.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class CalculateTest 3.1.
 * @author rzhedunov.
 * @since 2017-09-21.
 * @version 3.2.
 */
public class CalculatorTest {
    /**
     * Method whenAddOnePlusOneThenTwo tests Calculator.add method.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Method whenSubtractOneFromOneThenZero tests Calculator.subtract method.
     */
    @Test
    public void whenSubtractOneFromOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtract(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /**
     * Method whenDivOneByOneThenOne tests Calculator.div method.
     */
    @Test
    public void whenDivOneByOneThenOne() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Method whenDivOneByZeroThenException tests Calculator.div method.
     * Выпадение Exception (конкретно ArithmeticException) при делении на 0 является правильным поведением программы.
     * Но java не дает исключения, может потому, что тип double?
     * Прикрутил проверку значения calc.getResult() на бесконечность - правильно ли это?
     */
    @Test //(expected = Exception.class)
    public void whenDivOneByZeroThenException() {
        Calculator calc = new Calculator();
        calc.div(1D, 0D);
        //calc.div(1D, 1D); //При неравенстве второго аргумента нулю тест падает
        assertEquals("divide float by zero should be infinity", true, Double.isInfinite(calc.getResult()));
    }

    /**
     * Method whenMultiplyOneAndOneThenOne tests Calculator.multiply method.
     */
    @Test
    public void whenMultiplyOneAndOneThenOne() {
        Calculator calc = new Calculator();
        calc.multiple(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
}