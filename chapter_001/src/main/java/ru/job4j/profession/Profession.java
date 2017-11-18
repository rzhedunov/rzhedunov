package ru.job4j.profession;

/**
 * Class Profession 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-11
 * @version 002.2.2.1
 */
public class Profession {
    /** Поле имени специалиста. */
    private String name;

    /** Поле заработная плата. */
    private int salary;

    /**
    * Method setName sets a name.
    * @param name is the name of profession.
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Method getName returns the name of the profession.
    * * returns String
    */
    public String getName() {
        return this.name;
    }

    /**
     * Method getSalary returns the salary of specialist.
     * @return int
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Method setSalary sets a salary to the specialist.
     * @param salary is the value of salary.
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }


}
