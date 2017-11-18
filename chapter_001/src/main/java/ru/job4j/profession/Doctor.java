package ru.job4j.profession;

import ru.job4j.organization.Hospital;
import ru.job4j.Human;

/**
 * Class Doctor 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-11
 * @version 002.2.2.1
 */
public class Doctor extends Profession {
    /** Поле названия больницы.
     * Предполагается, что доктор работает только в одной больнице
     * */
    private Hospital hospital;


    /**
     * Method setHospital sets a hospital name.
     * @param hospital is the name of profession.
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Method getHospital returns the hospital.
     * * returns Hospital
     */
    public Hospital getHospital() {
        return this.hospital;
    }

    /**
     * Method diagnoseHeal returns the string about "Доктор Иван лечит пациента Сергей".
     * * returns String
     */
    public String diagnoseHeal(Human human) {
        return "Доктор " + this.getName() + " лечит пациента " + human.getName();
    }
}
