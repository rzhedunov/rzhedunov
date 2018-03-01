package ru.job4j.tracker;

/**
 * Class ValidateInput 002.6.1.
 *
 * @author rzhedunov
 * @version 002.6.1.
 * @since 2017-03-01
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод запроса пункта меню с проверкой на соответствие.
     *
     * @param question вопрос.
     * @param range спектр ответов.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                moe.printStackTrace();
                System.out.println("Пожалуйста, введите номер!");
            } catch (NumberFormatException nfe) {
                System.out.println("Пожалуйста, введите правильные данные!");
            }

        } while (invalid);
        return value;
    }
}
