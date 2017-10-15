package ru.job4j.string;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Class StringOperationsTest  7.2.
 * @author rzhedunov.
 * @since 2017-10-15.
 * @version 7.2
 */
public class StringOperationsTest {
    /**
     * Method whenOneStringContainsAnotherThenTrue tests the case when one string contains another.
     */
    @Test
    public void whenOneStringContainsAnotherThenTrue() {
        String origin = "Привет";
        String sub = "Привет";
        StringOperations stringOperations = new StringOperations();
        boolean result = stringOperations.contains(origin, sub);
        assertTrue(result);
    }

    /**
     * Method whenOneStringDoesNotContainsAnotherThenTrue tests the case when one string does not contains another.
     */
    @Test
    public void whenOneStringDoesNotContainsAnotherThenTrue() {
        String origin = "Привет";
        String sub = "иве-";
        StringOperations stringOperations = new StringOperations();
        boolean result = stringOperations.contains(origin, sub);
        assertFalse(result);
    }
}
