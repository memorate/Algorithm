package sort;

import java.util.Arrays;

/**
 * @author Anchor
 *
 * 直接插入排序:
 *
 */
public class Insert {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 6, 1, 7, 4, 5};
        System.out.println(Arrays.toString(insert(array)));
    }

    private static int[] insert(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {

            }
        }
        return array;
    }
}
