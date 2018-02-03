package ru.job4j.strategy;


/**
 * Class Paint 022.4.4.
 * @author rzhedunov.
 * @since 2018-02-03.
 * @version 022.4.4.
 */
public class Paint {
    /**
     * Method to draw shape.
     * @param shape is the shape given
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
