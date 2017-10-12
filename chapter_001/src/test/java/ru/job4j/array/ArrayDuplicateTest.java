package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;

/**
 * Class ArrayDuplicateTest 6.3.
 * @author rzhedunov.
 * @since 2017-10-12.
 * @version 6.3
 */
public class ArrayDuplicateTest {
    /**
     * Method whenRemoveDuplicatesThenArrayWithoutDuplicate tests the return with the example provided.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] array = {"Мир", "Привет", "Привет", "Супер", "Мир", "Привет", "Мир"};

        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] arrayWithoutDuplicates = arrayDuplicate.remove(array);
        Arrays.sort(arrayWithoutDuplicates);

        String[] expected =  {"Мир", "Супер", "Привет"};
        Arrays.sort(expected);

        assertThat(arrayWithoutDuplicates, is(expected));
    }
}
