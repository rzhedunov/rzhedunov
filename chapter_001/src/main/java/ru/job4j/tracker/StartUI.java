package ru.job4j.tracker;

/**
 * Class StartUI 002.1.1.
 * @author rzhedunov
 * @since 2017-12-21
 * @version 002.1.1.
 */
public class StartUI {

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для нахождения заявки по ее Id.
     */
    private static final String FINDBYID = "4";
    /**
     * Константа меню для нахождения заявки по ее name.
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Enter a number : ");
            if (ADD.equals(answer)) {
                createItem();
            } else if (SHOWALL.equals(answer)) {
                showAllItems();
            } else if (EDIT.equals(answer)) {
                editItem();
            } else if (DELETE.equals(answer)) {
                deleteItem();
            } else if (FINDBYID.equals(answer)) {
                findById();
            } else if (FINDBYNAME.equals(answer)) {
                findByName();
            } else if (EXIT.equals(answer)) {
                System.out.println("Выход");
                exit = true;
            }
        }

    }

    /**
     * Метод реализует добавления новой заявки в хранилище.
     */
    private void createItem() throws Exception{
        //System.out.println("Добавление");
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод списка заявок из хранилища.
     */
    private void showAllItems() {
        System.out.println("Вывод всех");
    }

    /**
     * Метод реализует редактирование выбираемой заявки.
     */
    private void editItem() {
        System.out.println("Редактирование");
    }

    /**
     * Метод реализует удаление выбираемой заявки.
     */
    private void deleteItem() {
        System.out.println("Удаление");
    }

    /**
     * Метод реализует поиск заявки по идентификатору.
     */
    private void findById() {
        System.out.println("Поиск по номеру");
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findByName() {
        System.out.println("Поиск по названию");
    }

    /**
     * Метод реализует вывод меню.
     */
    private void showMenu() {
        System.out.println("--------------------------");
        System.out.println("Menu:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select (Enter a number):");
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main (String[] args) throws Exception {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
