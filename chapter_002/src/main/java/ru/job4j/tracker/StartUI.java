package ru.job4j.tracker;

/**
 * Class StartUI 002.1.1.
 * @author rzhedunov
 * @since 2017-12-21
 * @version 002.4.3.
 */
public class StartUI {
    /** Константа для выхода из цикла.   */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор, инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() throws Exception {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
             menu.show();
             int key = Integer.valueOf(input.ask("Выберите пункт меню: "));
             menu.select(key);
             if (key == Integer.valueOf(EXIT)) {
                 break;
             }
        } while (true);
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
