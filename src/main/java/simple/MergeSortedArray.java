package simple;

import java.util.Arrays;

/**
 * 88.【合并两个有序数组】
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 *
 *   输入:
 *     nums1 = [1,2,3,0,0,0], m = 3
 *     nums2 = [2,5,6],       n = 3
 *
 *   输出:
 *     [1,2,2,3,5,6]
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] m1 = {4, 5, 6, 0, 0, 0};
        int[] m2 = {1, 2, 3};
//        MySolution(m1, 3, m2, 3);
        LeetCodeSolution1(m1, 3, m2, 3);

        int[] n1 = {1, 2, 3, 0, 0, 0};
        int[] n2 = {2, 5, 6};
//        MySolution(n1, 3, n2, 3);
        LeetCodeSolution1(n1, 3, n2, 3);

        int[] o1 = {2, 0};
        int[] o2 = {1};
//        MySolution(o1, 1, o2, 1);
        LeetCodeSolution1(o1, 1, o2, 1);

        int[] p1 = {0};
        int[] p2 = {1};
//        MySolution(p1, 0, p2, 1);
        LeetCodeSolution1(p1, 0, p2, 1);
    }

    /**
     * 双指针
     * 倒序比较两个数组中的元素，每次讲较大的放在 nums1 的当前末位
     * main 方法中后三种测试案例较为复杂，需要考虑清楚各种边界问题
     * 最终无非就两种情况：
     * nums1 为空 和 nums2 为空
     */
    static void MySolution(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1, y = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (x < 0) {
                nums1[i] = nums2[y];
                y--;
                continue;
            }
            if (y < 0) break;
            if (nums1[x] >= nums2[y]) {
                nums1[i] = nums1[x];
                x--;
            } else {
                nums1[i] = nums2[y];
                y--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 双指针 + 倒序比较
     *
     * 秀啊
     * 直接拿 m、n 作为双指针，边界判断简洁很多
     */
    static void LeetCodeSolution1(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;
        while (n >= 0) {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 官方解答
     */
    static void LeetCodeSolution2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
