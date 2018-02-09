package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PaintTest 002.4.5.
 * @author rzhedunov.
 * @since 2018-02-09.
 * @version 002.4.5.
 */
public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("before-method executed");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.out.println("after-method executed ");
        System.setOut(this.stdout);
    }


    /**
     * Method whenDrawSquare tests drawing the square.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
    * Method whenDrawTriangle tests drawing the triangle.
    */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        // проверяем результат вычисления
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("+")
                                .append("++")
                                .append("+ +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}