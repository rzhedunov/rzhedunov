package ru.job4j.tracker;

import java.util.*;
/**
 * Class ConsoleInput 002.1.1.
 * @author rzhedunov
 * @since 2017-12-21
 * @version 002.1.1.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
