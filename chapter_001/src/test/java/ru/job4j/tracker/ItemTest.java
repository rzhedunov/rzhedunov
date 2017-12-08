package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotNull;


/**
 * Class ItemTest 022.3.2.
 * @author rzhedunov.
 * @since 2017-12-08.
 * @version 022.3.2.
 */
public class ItemTest {
    /**
     * Method whenAddTwoCommentsToNewItemThenShowsThem tests creation of new Item and adding Two Comments to it.
     */
    @Test
    public void whenAddCommentsToNewItemThenShowsThem() throws  Exception {
        //Создать экземпляр Item, добавить два комментария, проверить, что их столо два
        //Добавить третий комментарий, проверить, что он доступен
        //Удалить третий комментарий, проверить, что при попытке доступа возникает исключение
        Item item = new Item();
        item.addComment("FirstComment");
        item.addComment("SecondComment");
        assertThat(item.getCntComments(), is(2));
        item.addComment("ThirdComment");
        try {
            String expected = item.getComment(3);
            assertThat(item.getComment(3), is(expected));
        } catch (Exception e) {
            //System.out.println(e.getMessage());
        }

        item.deleteComment(2);
        Exception thrown = null;
        try {
            String expected = item.getComment(3);
        } catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }

    /**
     * Method whenAddMoreThanTenCommentsThenThrowException tests exception then adding eleventh comment.
     */
    @Test
    public void whenAddMoreThanTenCommentsThenThrowException() throws  Exception {
        //При добавлении 11-го комментария, должно выпадать исключение
        Exception thrown = null;
        try {
            Item item = new Item();
            for (int i = 0; i < 11; i++) {
                item.addComment("" + (i - 1));
            }
        } catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }
}
