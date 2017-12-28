package ru.job4j.tracker;

import java.util.Date;
import java.util.Arrays;

/**
 * Class Tracker 002.1.1.
 * @author rzhedunov
 * @since 2017-12-06
 * @version 002.1.1.
 */
public class Tracker {
    /** Storage - array of 100 Items. */
    private final Item[] items = new Item[100];
    /** Указатель ячейки для новой заявки.*/
    private int position = 0;

    /**
     * Method getPosition - Position-getter.
     * @return int.
     */

    public int getPosition() {
        return position;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return "Number" + (new Date().getTime());
    }

    /**
     * Method findById - finds Item in storage by its Id.
     * @return Item.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
            }
        }
        return result;
    }

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) throws Exception {
        if (this.position < 100) {
            item.setId(this.generateId());
            this.items[this.position++] = item;
            return item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Method update - replaces the Item given with new Item.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                System.gc();
                items[i] = item;
            }
        }
    }

    /**
     * Method delete - deletes Item from storage by its Id.
     */
    public void delete(String id) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, (position - 1 - i));
                break;
            }
        }
        items[position - 1] = null;
        this.position--;
    }

    /**
     * Method findAll - finds all notNull-Items in storage.
     * @return Item[].
     */
    public Item[] findAll() {
        //Узнать размер будущего результирующего массива
        int newSize = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null) {
                newSize++;
            }
        }
        Item[] result = new Item[newSize];
        int newPosition = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null) {
                result[newPosition++] = items[i];
            }
        }
        return  result;
    }

    /**
     * Method findByName - gets all Items from storage by their Name.
     * @return Item[].
     */
    public Item[] findByName(String name) {
        //Узнать размер будущего результирующего массива
        int newSize = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(name)) {
                newSize++;
            }
        }
        Item[] result = new Item[newSize];
        int newPosition = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i].getName().equals(name)) {
                result[newPosition++] = items[i];
            }
        }
        return  result;
    }
}
