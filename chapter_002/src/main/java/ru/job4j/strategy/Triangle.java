package ru.job4j.strategy;
/**
 * Class Triangle 022.4.4.
 * @author rzhedunov.
 * @since 2018-02-03.
 * @version 022.4.4.
 */
public class Triangle implements Shape {
    /**
     * Method to draw shape.
     * @return String
     */
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+");
        pic.append("++");
        pic.append("+ +");
        pic.append("++++");
        return pic.toString();
    }
}
