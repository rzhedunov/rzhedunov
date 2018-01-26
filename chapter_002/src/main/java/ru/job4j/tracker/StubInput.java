package ru.job4j.tracker;

/**
 * Class StubInput 002.4.3.
 * @author rzhedunov
 * @since 2018-01-11
 * @version 002.4.3.
 */
public class StubInput implements Input {
    /** A table of answers seria. */
    private String[] answers;
    /** Current answer's position. */
    private int position = 0;

    /**
     * Конструктор по умолчанию
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * A method to retrieve the next answer from stub class
     */
    public String ask(String question) {
        return answers[position++];
    }
}
