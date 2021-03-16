package sort;

import java.util.Arrays;

/**
 * @author Anchor
 *
 * 选择排序：
 *   1.定位到当前数组中最大的元素，将其与末尾元素互换
 *   2.排除数组末尾已排序的元素，继续执行第一步
 *
 * 时间复杂度: O(n²)
 * 空间复杂度: O(1)
 * 不稳定
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 6, 1, 7, 4, 5};
        System.out.println(Arrays.toString(select(array)));
    }

    private static int[] select(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        for (int i = array.length - 1; i > 0; i--) {
            int max = array[0], index = 0;
            for (int j = 0; j <= i; j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}