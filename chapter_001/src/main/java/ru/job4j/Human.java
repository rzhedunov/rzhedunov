package ru.job4j;

/**
 * Human 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-18
 * @version 002.2.2.1
 */
public class Human {
    /** Поле имени человека. */
    private String name;

    /**
     * Method setName sets a name.
     * @param name is the name of human.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getName returns the name of the human.
     * * returns String
     */
    public String getName() {
        return this.name;
    }
}
