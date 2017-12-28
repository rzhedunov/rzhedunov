package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Class TrackerTest 022.3.2.
 * @author rzhedunov.
 * @since 2017-12-08.
 * @version 022.3.2.
 */
public class TrackerTest {

    /**
     * Method whenAddNewItemThenTrackerHasSameItem tests Tracker.add and findAll methods.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item[] result = tracker.findAll();
        assertEquals(result[0], item);
    }

    /**
     * Method whenAddMoreThan100itemswhenThrowsException tests Tracker.add method.
     */
    @Test(expected = Exception.class)
    public void whenAddMoreThan100itemswhenThrowsException() throws Exception {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 100; i++) {
            Item item = new Item();
            tracker.add(item);
        }
        //При добавлении 101-го item, должно выпадать исключение
        Item item = new Item();
        tracker.add(item);
    }

    /**
     * Method whenReplaceNameThenReturnNewName tests Tracker.replace and findById methods.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() throws Exception {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertEquals(tracker.findById(previous.getId()).getName(), "test2");
    }

    /**
     * Method whenDeleteItemswhenGetLessPosition tests Tracker.delete method.
     */
    @Test
    public void whenDeleteItemswhenGetLessPosition() throws Exception {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 3; i++) {
            Item item = new Item();
            item.setId("Number" + i);
            tracker.add(item);
        }
        int maxRecords = tracker.getPosition();
        tracker.delete("Number2");
        int minRecords = tracker.getPosition();
        assertEquals(maxRecords - minRecords, 1);
    }

    /**
     * Method whenAddsItemWithSpecificNameWhenFindsIt tests Tracker.findByName method.
     */
    @Test
    public void whenAddsItemWithSpecificNameWhenFindsIt() throws Exception {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 3; i++) {
            Item item = new Item("UniversalName", "Desc" + i, i);
            item.setId("Number" + i);
            tracker.add(item);
        }
        Item[] result = tracker.findByName("UniversalName");
        assertEquals(result[1].getDesc(), "Desc1");
    }


}
