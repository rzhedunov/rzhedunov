package ru.job4j.calculator;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class CalculateTest 3.1.
 * @author rzhedunov.
 * @since 2017-09-21.
 * @version 3.1.
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