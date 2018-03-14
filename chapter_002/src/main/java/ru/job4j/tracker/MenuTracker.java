package ru.job4j.tracker;

/**
 * Class EditItem 002.4.6.
 *
 * @author rzhedunov
 * @version 002.4.6.
 * @since 2018-02-22
 */
// "Внешний" класс
class EditItems extends BaseAction {
    public EditItems() {
        super(2, "Edit item. ");
    }

    //Редактирование заявки осуществляю без замены объекта Item
    public void execute(Input input, Tracker tracker) throws Exception {
        String id = input.ask("Enter the Id of the searched item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.ask("Enter the new name of the item:");
            String desc = input.ask("Enter the new description of the item:");
            item.setName(name);
            item.setDesc(desc);
        } else {
            System.out.println("The item with this id was not found!");
        }
    }

}

/**
 * Class MenuTracker 002.4.6.
 *
 * @author rzhedunov
 * @version 002.4.6.
 * @since 2018-02-22
 */
public class MenuTracker {
    /**
     * Переменная хранилища заявок.
     */
    private Tracker tracker;
    /**
     * Переменная канала ввода данных.
     */
    private Input input;
    /**
     * Массив с пунктами меню
     */
    private UserAction[] actions = new UserAction[7];

    /**
     * Конструктор, инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод инициализации меню.
     */
    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItems();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemsByName();
        this.actions[6] = new ExitProgram();
    }

    /**
     * Метод выбора пункта меню.
     */
    public void select(int key) throws Exception {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Метод печати меню.
     */
    public void show() {

        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Class MenuTracker.AddItem 002.4.6.
     *
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private class AddItem extends BaseAction {
        public AddItem() {
            super(0, "Add the new item. ");
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            String name = input.ask("Enter the item name: ");
            String desc = input.ask("Enter the item description: ");
            tracker.add(new Item(name, desc));
        }

    }

    /**
     * Class MenuTracker.ShowItems 002.4.6.
     *
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class ShowItems extends BaseAction {
        public ShowItems() {
            super(1, "Show all items. ");
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
            }
        }
    }

    /**
     * Class MenuTracker.DeleteItem 002.4.6.
     *
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class DeleteItem extends BaseAction {
        public DeleteItem() {
            super(3, "Delete item. ");
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            String id = input.ask("Enter the id of the searched item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(item.getId());
            } else {
                System.out.println("The item with this id was not found!");
            }
        }
    }

    /**
     * Class MenuTracker.FindItemById 002.4.6.
     *
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class FindItemById extends BaseAction {
        public FindItemById() {
            super(4, "Find item by id. ");
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            String id = input.ask("Enter the id of the searched item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("" + item.getId() + " " + item.getName());
            } else {
                System.out.println("The item with this id was not found!");
            }

        }
    }

    /**
     * Class MenuTracker.FindItemsByName 002.4.6.
     *
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class FindItemsByName extends BaseAction {
        public FindItemsByName() {
            super(5, "Find items by name. ");
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            String name = input.ask("Enter the name of the searched items: ");
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                for (Item item : items) {
                    System.out.println("" + item.getId() + "  " + item.getName() + "  " + item.getDesc());
                }
            } else {
                System.out.println("Items were not found!");
            }
        }
    }

    /**
     * Class MenuTracker.ExitProgram 002.4.6.
     *
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class ExitProgram extends BaseAction {
        public ExitProgram() {
            super(6, "Exit program. ");
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            System.exit(0);
        }
    }

    /**
     * Метод генерации массива с номерами пунктов меню.
     * returns int[]
     */
    public int[] appMenuNumbers() {
        int numberOfNotNullPoints = 0;
        for (int i = 0; i < this.actions.length; i++) {
            if (this.actions[i] != null) {
                numberOfNotNullPoints++;
            }
        }
        int[] menuNumbers = new int[numberOfNotNullPoints];
        numberOfNotNullPoints = 0;
        for (int i = 0; i < this.actions.length; i++) {
            if (this.actions[i] != null) {
                menuNumbers[numberOfNotNullPoints++] = i;
            }
        }
        return menuNumbers;
    }
}
