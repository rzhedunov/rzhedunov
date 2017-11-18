package ru.job4j.profession;

import ru.job4j.organization.School;
import ru.job4j.Human;

/**
 * Class Teacher 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-18
 * @version 002.2.2.1
 */
public class Teacher extends Profession {
    /** Поле названия школы.
     * Предполагается, что доктор работает только в одной больнице
     * */
    private School school;

    /**
     * Method setSchool sets a school name.
     * @param school is the name of profession.
     */
    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * Method getSchool returns the school.
     * * returns School
     */
    public School getSchool() {
        return this.school;
    }

    /**
     * Method teachPerson returns the string about "Учитель Иван учит ученика Сергей".
     * * returns String
     */
    public String teachPerson(Human human) {
        return "Учитель " + this.getName() + " учит ученика " + human.getName();
    }
}
