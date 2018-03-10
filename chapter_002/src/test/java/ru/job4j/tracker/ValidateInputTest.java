package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 * Class ValidateTest 002.6.2.
 *
 * @author rzhedunov.
 * @version 002.6.2.
 * @since 2018-03-10.
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    /**
     * Method loadMem reassign system output stream.
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Method loadSys returns system output to default stream
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Method whenInvalidInput tests validating of input
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Пожалуйста, введите правильные данные!\r\n")
                )
        );
    }
}
