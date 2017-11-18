package ru.job4j.profession;

import org.junit.Test;

import ru.job4j.Human;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class EngineerTest 002.2.1.1.
 * @author rzhedunov.
 * @since 2017-11-18.
 * @version 002.2..1.1
 */
public class EngineerTest {
    /**
     * Method buildForPersonTest tests Engeneer.buildForPerson method.
     */
    @Test
    public void buildForPersonTest() {
        Engineer engineer = new Engineer();
        engineer.setName("Иван");
        Human client = new Human();
        client.setName("Сергей");
        String resultName = engineer.buildForPerson(client);
        assertThat(resultName, is("Инженер Иван строит для заказчика Сергей"));
    }
    /**
     * Method getAccessFromDoctorTest tests Engeneer.getAccessFromDoctor method.
     */
    @Test
    public void getAccessFromDoctorTest() {
        Engineer engineer = new Engineer();
        engineer.setName("Иван");
        Doctor doctor = new Doctor();
        doctor.setName("Сергей");
        String resultName = engineer.getAccessFromDoctor(doctor);
        assertThat(resultName, is("Инженер Иван допущен к работе доктором Сергей"));
    }
}
