package leetcode.hard;

/**
 * 4.【寻找两个正序数组的中位数】
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
 *
 * 示例 1：
 *   输入：nums1 = [1,3], nums2 = [2]
 *   输出：2.00000
 *   解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 *   输入：nums1 = [1,2], nums2 = [3,4]
 *   输出：2.50000
 *   解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 *   输入：nums1 = [0,0], nums2 = [0,0]
 *   输出：0.00000
 *
 * 示例 4：
 *   输入：nums1 = [], nums2 = [1]
 *   输出：1.00000
 *
 * 示例 5：
 *   输入：nums1 = [2], nums2 = []
 *   输出：2.00000
 *
 * 提示：
 *   nums1.length == m
 *   nums2.length == n
 *   0 <= m <= 1000
 *   0 <= n <= 1000
 *   1 <= m + n <= 2000
 *   -106 <= nums1[i], nums2[i] <= 106
 *
 * @author Anchor
 * @date 2021-05-04 14:33
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length,
                l = m + n, i = m-- + --n, last = 0;
        for (; i >= l / 2 - 1; i--) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                last = nums1[m];
            } else {
                last = nums2[n];
            }
        }
        while (i >= l / 2 - 1) {
            if (i == l / 2 - 1) {
                if (l % 2 == 0) {
                    last += m >= 0 && nums1[m] > nums2[n] ? nums1[m] : nums2[n];
                    return (double) last / 2;
                } else {
                    return last;
                }
            }
            if (m >= 0 && nums1[m] > nums2[n]) {
                last = nums1[m];
                if (m != 0) m--;
            } else {
                last = nums2[n];
                if (n != 0) n--;
            }
            i--;
        }
        return 0;
    }
}
