package ru.job4j.organization;

/**
 * Class Hospital 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-11
 * @version 002.2.2.1
 */
public class Hospital {
    /** Поле названия больницы. */
    private String name;

    /**
     * Method setName sets a name.
     * @param name is the name of hospital.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method getName returns the name of the hospital.
     * * returns String
     */
    public String getName() {
        return this.name;
    }
}
