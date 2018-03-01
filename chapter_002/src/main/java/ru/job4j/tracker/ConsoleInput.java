package ru.job4j.tracker;

import java.util.*;

/**
 * Class ConsoleInput 002.1.1.
 *
 * @author rzhedunov
 * @version 002.1.1.
 * @since 2017-12-21
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    /**
     * A method to retrieve the next answer from console
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * A method to retrieve the next answer from console
     */
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Выбран несуществующий пункт меню!");
        }
    }
}
