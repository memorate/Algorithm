package sort;

import java.util.Arrays;

/**
 * @author Anchor
 *
 * 直接插入排序:
 *   1.将第一元素当做一个有序数组，将第二至最后一个元素当做一个无序数组
 *   2.遍历无序数组，每次取一个元素插入有序数组中
 *
 * 时间复杂度: O(n²)
 * 空间复杂度: O(1)
 * 稳定
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 6, 1, 7, 4, 5};
        System.out.println(Arrays.toString(insertSort(array)));
    }

    private static int[] insertSort(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
        return array;
    }
}
