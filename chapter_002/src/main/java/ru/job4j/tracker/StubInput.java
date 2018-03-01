package ru.job4j.tracker;

/**
 * Class StubInput 002.4.3.
 *
 * @author rzhedunov
 * @version 002.4.3.
 * @since 2018-01-11
 */
public class StubInput implements Input {
    /**
     * A table of answers seria.
     */
    private String[] answers;
    /**
     * A table of answers numbers.
     */
    private int[] numberOfAnswers = {0, 1, 2, 3, 4, 5, 6};
    /**
     * Current answer's position.
     */
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

    /**
     * The second method to retrieve the next answer from stub class (as an int)
     */
    public int ask(String question, int[] range) throws MenuOutException {
        return Integer.valueOf(answers[position++]);
    }
}
