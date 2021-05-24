package sort;

import java.util.Arrays;

/**
 * 快速排序
 * 在数组中选择一个基准点 pivot，遍历，将大于 pivot 的数据放在 pivot 的右边，小于 pivot 的数据放在 pivot 的左边
 * pivot 左边和右边的小数组在重复进行第一步，直到最后一次递归的数组中只有一个元素
 *
 * O(nlogn)
 *
 * 参考：
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195042&idx=1&sn=2b0915cd2298be9f2163cc90a3d464da&
 * chksm=8c99f9f8bbee70eef627d0f5e5b80a604221abb3a1b5617b397fa178582dcb063c9fb6f904b3&scene=21#wechat_redirect
 *
 * @author Anchor
 * @date 2021-04-19 14:39
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] num = {4, 7, 6, 5, 3, 2, 8, 1};
        new QuickSort().quickSort(num);
        System.out.println(Arrays.toString(num));
    }

    public void quickSort(int[] num) {
        if (num == null || num.length == 0 || num.length == 1) return;
        partition(num, 0, num.length - 1);
    }

    public void partition(int[] num, int left, int right) {
        if (left > right) return;
        // 选取数组中第一个数为 pivot
        int pivot = num[left];
        // 双指针法
        int l = left, r = right;
        while (l != r) {
            // 控制右指针比较并左移
            while (num[r] >= pivot && l < r) {
                r--;
            }
            // 控制左指针比较并右移
            while (num[l] <= pivot && l < r) {
                l++;
            }
            // 左右指针所指的元素交换
            if (l < r) {
                int tmp = num[l];
                num[l] = num[r];
                num[r] = tmp;
            }
        }
        num[left] = num[l];
        // 将基准数放在中间位置
        num[l] = pivot;
        partition(num, left, l - 1);
        partition(num, l + 1, right);
    }
}
