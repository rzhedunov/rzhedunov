package ru.job4j.profession;

import ru.job4j.Human;

/**
 * Class Engineer 002.2.1.1
 * @author rzhedunov
 * @since 2017-11-18
 * @version 002.2.2.1
 */
public class Engineer extends Profession {

    /**
     * Method buildForPerson returns the string about "Инженер Иван строит для заказчика Сергей".
     * * returns String
     */
    public String buildForPerson(Human human) {
        return "Инженер " + this.getName() + " строит для заказчика " + human.getName();
    }

    /**
     * Method getAccessFromDoctor returns the string about "Инженер Иван допущен к работе доктором Сергей".
     * * returns String
     */
    public String getAccessFromDoctor(Doctor doctor) {
        return "Инженер " + this.getName() + " допущен к работе доктором " + doctor.getName();
    }


}
