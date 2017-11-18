package ru.job4j.organization;

/**
 * Class School 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-18
 * @version 002.2.2.1
 */
public class School {
    /** Поле названия школы. */
    private String name;

    /**
     * Method setName sets a name.
     * @param name is the name of school.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getName returns the name of the school.
     * * returns String
     */
    public String getName() {
        return this.name;
    }
}
