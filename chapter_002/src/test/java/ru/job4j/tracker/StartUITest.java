package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartUITest 022.4.3.
 * @author rzhedunov.
 * @since 2018-01-11.
 * @version 022.4.3.
 */

public class StartUITest {
    /**
     * Method whenUserAddItemThenTrackerHasNewItemWithSameName tests creation of new Item.
     */
    @Test
    public void whenUserAddsItemThenTrackerHasNewItemWithSameName() throws Exception {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Method whenUserUpdatesItemThenTrackerHasUpdatedItem tests update of existing Item.
     */
    @Test
    public void whenUserUpdatesItemThenTrackerHasUpdatedItem() throws Exception {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));

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
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));

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
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));

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
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем две заявки с одинаковым именем
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name", "desc2"));

        //создаём StubInput с последовательностью действий
        //5 - пункт "Найти по имени", item.getId() - id of existing item, then exit
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что массив Items в трекере содержит две записи
        assertThat(tracker.getPosition(), is(2));
    }
}
