package ru.job4j.profession;

import org.junit.Test;

import ru.job4j.Human;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class TeacherTest 002.2.1.1.
 * @author rzhedunov.
 * @since 2017-11-18.
 * @version 002.2..1.1
 */
public class TeacherTest {
    /**
     * Method teachPerson tests Teacher.teachPerson method.
     */
    @Test
    public void teachPersonTest() {
        Teacher teacher = new Teacher();
        teacher.setName("Иван");
        Human pupil = new Human();
        pupil.setName("Сергей");
        String resultName = teacher.teachPerson(pupil);
        assertThat(resultName, is("Учитель Иван учит ученика Сергей"));
    }
}
