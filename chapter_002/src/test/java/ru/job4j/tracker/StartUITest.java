package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartUITest 022.4.3.
 * @author rzhedunov.
 * @since 2018-01-11.
 * @version 022.4.3.
 */

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    // поле Tracker
    private Tracker tracker = new Tracker();

    @Before
    public void loadOutput() throws Exception {
        // добавляем в трекер одну тестовую заявку
        Item item = tracker.add(new Item("test name", "desc"));
        System.out.println("before-method executed");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("after-method executed ");
    }


    /**
     * Method whenUserAddItemThenTrackerHasNewItemWithSameName tests creation of new Item.
     */
    @Test
    public void whenUserAddsItemThenTrackerHasNewItemWithSameName() throws Exception {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[1].getName(), is("test name")); // проверяем, что элемент массива с индексом 1 в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Method whenUserUpdatesItemThenTrackerHasUpdatedItem tests update of existing Item.
     */
    @Test
    public void whenUserUpdatesItemThenTrackerHasUpdatedItem() throws Exception {
        Item item = tracker.findAll()[0];
        //создаём StubInput с последовательностью действий
        //2 - пункт "изменить", item.getId() - id of existing item, then new values for item, then exit
        Input input = new StubInput(new String[]{"2", item.getId(), "test name2", "desc2", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит измененное имя.
        assertThat(tracker.findById(item.getId()).getName(), is("test name2"));
    }

    /**
     * Method whenUserDeletesItemThenTrackerDoesntHaveDeletedItem tests deletion of existing Item.
     */
    @Test
    public void whenUserDeletesItemThenTrackerDoesntHaveDeletedItem() throws Exception {
        Item item = tracker.findAll()[0];
        //создаём StubInput с последовательностью действий
        //3 - пункт "удалить", item.getId() - id of existing item, then exit
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что массив Item в трекере не содержит элементов.
        assertThat(tracker.getPosition(), is(0));
    }

    /**
     * Method whenUserSearchesItemByIdThenTrackerReturnsTheItem tests findingById of existing Item.
     */
    @Test
    public void whenUserSearchesItemByIdThenTrackerReturnsTheItem() throws Exception {
        Item item = tracker.findAll()[0];

        //создаём StubInput с последовательностью действий
        //4 - пункт "Найти по Id", item.getId() - id of existing item, then exit
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что массив Item в трекере не содержит элементов.
        assertThat(tracker.findById(item.getId()), is(item));
    }

    /**
     * Method whenUserSearchesItemsByNameThenTrackerReturnsTheArrayOfItems tests finding items by name.
     */
    @Test
    public void whenUserSearchesItemsByNameThenTrackerReturnsTheArrayOfItems() throws Exception {
        Item item1 = tracker.findAll()[0];
        Item item2 = tracker.add(new Item("test name", "desc2"));

        //создаём StubInput с последовательностью действий
        //5 - пункт "Найти по имени", item.getId() - id of existing item, then exit
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что массив Items в трекере содержит две записи
        assertThat(tracker.getPosition(), is(2));
    }

    /**
     * Method whenUserStartsProgramThenProgramShowsMenu tests displaying the menu.
     */
    @Test
    public void whenUserStartsProgramThenProgramShowsMenu() throws Exception {

        //создаём StubInput с единственным действием - выходом из программы
        Input input = new StubInput(new String[]{"6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        String ls = System.lineSeparator(); //Разделитель строк для вывода
        // проверяем, что консольный вывод содержит меню приложения.
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("--------------------------").append(ls)
                                .append("Menu:").append(ls)
                                .append("0. Add new Item").append(ls)
                                .append("1. Show all items").append(ls)
                                .append("2. Edit item").append(ls)
                                .append("3. Delete item").append(ls)
                                .append("4. Find item by Id").append(ls)
                                .append("5. Find items by name").append(ls)
                                .append("6. Exit Program").append(ls)
                                .append("Select (Enter a number):Выход").append(ls)
                                .toString()
                )
        );
    }

    /**
     * Method whenUserSearchesTheItemThenProgramShowsMenuAndTheItem tests displaying the menu and the test Item.
     */
    @Test
    public void whenUserSearchesTheItemThenProgramShowsMenuAndTheItem() throws Exception {

        //создаём StubInput с единственным действием - выходом из программы
        Input input = new StubInput(new String[]{"1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        String numberOfTestItem = tracker.findAll()[0].getId();
        String ls = System.lineSeparator(); //Разделитель строк для вывода
        // проверяем, что консольный вывод содержит меню приложения и выданный список с одним элементом.
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("--------------------------").append(ls)
                                .append("Menu:").append(ls)
                                .append("0. Add new Item").append(ls)
                                .append("1. Show all items").append(ls)
                                .append("2. Edit item").append(ls)
                                .append("3. Delete item").append(ls)
                                .append("4. Find item by Id").append(ls)
                                .append("5. Find items by name").append(ls)
                                .append("6. Exit Program").append(ls)
                                .append("Select (Enter a number):Вывод всех").append(ls)
                                .append("Id                   Name      Description ").append(ls)
                                .append("------------------------------------------ ").append(ls)
                                .append(numberOfTestItem + "  test name  desc").append(ls)
                                .append("--------------------------").append(ls)
                                .append("Menu:").append(ls)
                                .append("0. Add new Item").append(ls)
                                .append("1. Show all items").append(ls)
                                .append("2. Edit item").append(ls)
                                .append("3. Delete item").append(ls)
                                .append("4. Find item by Id").append(ls)
                                .append("5. Find items by name").append(ls)
                                .append("6. Exit Program").append(ls)
                                .append("Select (Enter a number):Выход").append(ls)
                                .toString()
                )
        );



    }


}
