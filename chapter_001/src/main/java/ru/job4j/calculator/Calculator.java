package ru.job4j.calculator;

/**
 * Class Calculate 3.1.
 * @author rzhedunov
 * @since 2017-09-21
 * @version 3.1
 */
public class Calculator {
    /** Поле результата операции. */
    private double result;

    /**
    * Method add adds two numbers.
    * @param first first added number.
    * @param second second added number.
    */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
    * Method subtract subtracts two numbers.
    * @param first first number.
    * @param second second number.
    */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
    * Method div realize division of two numbers.
    * @param first first number.
    * @param second second number.
    */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
    * Method multiply multiplies two numbers.
    * @param first first number.
    * @param second second number.
    */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
    * Method getResult returns operation result.
    * @return double.
    */
    public double getResult() {
        return this.result;
    }
}
