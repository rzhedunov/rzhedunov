package ru.job4j.tracker;

/**
 * Class EditItem 002.4.6.
 * @author rzhedunov
 * @version 002.4.6.
 * @since 2018-02-22
 */
// "Внешний" класс
class EditItems implements UserAction {
    //@Override
    public int key() {
        return 2;
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

    //@Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item. ");
    }
}

/**
 * Class MenuTracker 002.4.6.
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
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private class AddItem implements UserAction {
        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            String name = input.ask("Enter the item name: ");
            String desc = input.ask("Enter the item description: ");
            tracker.add(new Item(name, desc));
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item. ");
        }
    }

    /**
     * Class MenuTracker.ShowItems 002.4.6.
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class ShowItems implements UserAction {
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) throws Exception {
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items. ");
        }
    }

    /**
     * Class MenuTracker.DeleteItem 002.4.6.
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class DeleteItem implements UserAction {
        public int key() {
            return 3;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item. ");
        }
    }

    /**
     * Class MenuTracker.FindItemById 002.4.6.
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class FindItemById implements UserAction {
        //@Override
        public int key() {
            return 4;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by id. ");
        }
    }

    /**
     * Class MenuTracker.FindItemsByName 002.4.6.
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class FindItemsByName implements UserAction {
        //@Override
        public int key() {
            return 5;
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

        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name. ");
        }
    }

    /**
     * Class MenuTracker.ExitProgram 002.4.6.
     * @author rzhedunov
     * @version 002.4.6.
     * @since 2018-02-22
     */
    private static class ExitProgram implements UserAction {
        //@Override
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) throws Exception {
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit program. ");
        }
    }
}
