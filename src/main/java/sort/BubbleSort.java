package sort;

import java.util.Arrays;

/**
 * @author Anchor
 *
 * 冒泡排序：
 *   for{
 *       1.前后俩元素对比，将较大的元素放在后面;
 *       2.一次 for 循环结束后，数组中最大的元素在末尾;
 *       3.将末尾元素剔除，再执行第一步;
 *   }
 *
 * 时间复杂度: O(n²)
 * 空间复杂度: O(1)
 * 稳定
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 6, 1, 7, 4, 5};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    private static int[] bubbleSort(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
