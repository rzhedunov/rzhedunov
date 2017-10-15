package ru.job4j.string;
/**
 * Class StringOperations 7.2.
 * @author rzhedunov
 * @since 2017-10-15
 * @version 7.2
 */
public class StringOperations {
    /**
     * Method contains(String origin, String sub) answers is one string contains another string.
     * @param origin is the first array given
     * @param sub is the second array given
     * @return int[]
     */
    boolean contains(String origin, String sub) {
        boolean result;
        if (origin.length() < sub.length()) {
            result = false;
        } else {
            char[] originchar = origin.toCharArray();
            char[] subchar = sub.toCharArray();
            result = false;
            for (int i = 0; i < (origin.length() - sub.length()) + 1; i++) {
                int flag = 1;
                for (int j = 0; j < sub.length(); j++) {
                    if (originchar[i + j] != subchar[j]) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
