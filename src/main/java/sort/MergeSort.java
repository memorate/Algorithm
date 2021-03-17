package sort;

import java.util.Arrays;

/**
 * @author Anchor
 *
 * 归并排序排序:
 *
 * 时间复杂度: O(n²)
 * 空间复杂度: O(1)
 * 稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 6, 1, 7, 4, 5};
        System.out.println(Arrays.toString(mergeSort(array)));
    }

    private static int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) return new int[0];
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] arr, int l, int r) {
        if (l == r) return;
        int m = l + (r - l) >> 1;
        sort(arr, l, m);
        sort(arr, m, r);
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {

    }
}
