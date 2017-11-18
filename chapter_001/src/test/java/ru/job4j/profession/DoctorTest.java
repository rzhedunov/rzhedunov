package ru.job4j.profession;

import org.junit.Test;
import ru.job4j.Human;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class DoctorTest 002.2.1.1.
 * @author rzhedunov.
 * @since 2017-11-18.
 * @version 002.2..1.1
 */
public class DoctorTest {
    /**
     * Method diagnoseHealTest tests Doctor.diagnoseHeal method.
     */
    @Test
    public void diagnoseHealTest() {
        Doctor doctor = new Doctor();
        doctor.setName("Иван");
        Human patient = new Human();
        patient.setName("Сергей");
        String resultName = doctor.diagnoseHeal(patient);
        assertThat(resultName, is("Доктор Иван лечит пациента Сергей"));
    }
}
