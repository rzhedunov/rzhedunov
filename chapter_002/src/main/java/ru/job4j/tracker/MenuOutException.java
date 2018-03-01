package ru.job4j.tracker;

/**
 * Class MenuOutException 002.6.1.
 *
 * @author rzhedunov
 * @version 002.6.1.
 * @since 2017-03-01
 */

public class MenuOutException extends Exception {
    /**
     * Конструктор.     *
     * @param msg сообщение к исключению.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
