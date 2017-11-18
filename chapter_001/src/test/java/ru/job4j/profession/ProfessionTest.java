package ru.job4j.profession;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class ProfessionTest 002.2.1.1.
 * @author rzhedunov.
 * @since 2017-11-11.
 * @version 002.2..1.1
 */
public class ProfessionTest {
    /**
     * Method setNameTest tests Profession.setName and Profession.getName methods.
     */
    @Test
    public void setNameTest() {
        Profession profession = new Profession();
        profession.setName("Точильщик");
        String resultName = profession.getName();
        assertThat(resultName, is("Точильщик"));
    }

    /**
     * Method setSalaryTest tests Profession.setSalary and Profession.getSalary methods.
     */
    @Test
    public void setSalaryTest() {
        Profession profession = new Profession();
        profession.setSalary(123);
        int resultSalary = profession.getSalary();
        assertThat(resultSalary, is(123));
    }
}