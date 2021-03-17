package simple;

/**
 * @author Anchor
 *
 * 69.【实现 int sqrt(int x) 函数】
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *  输入: 4
 *  输出: 2
 *
 * 示例 2:
 *  输入: 8
 *  输出: 2
 *  说明: 8 的平方根是 2.82842...,由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(MySolution(977));
        System.out.println(MySolution(9));
        System.out.println(MySolution(10));
        System.out.println(MySolution(8));
        System.out.println(MySolution(0));
        System.out.println(MySolution(1));
        System.out.println(MySolution(2));
    }

    /**
     * 二分法
     * n * n = x，找出离 n 最近且小于 n 的那个整数。由于 n * n 可能越界，因此条件改为 n < x/n
     * 查找范围为 [0, x]（为什么不是 [0, x/2]？为了兼容 x = 1 时算法可正常运行）
     *
     * 最后两个数怎么选：
     * 当 x = 8 时，最后区间是 [2, 3]
     * 当 x = 9 时，最后区间是 [2, 3]
     * 此时先判断 right 是否符合，因为 right 距 n 最近。若不符合，则一定是 left
     */
    static int MySolution(int x) {
        int left = 0, right = x;
        while (left < right) {
            // 选最后两数之一
            if (right - left == 1) return right <= x / right ? right : left;
            int mid = (left + right) >> 1;
            // mid * mid < x 可能会越界
            if (mid < x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // x = 0 时，平方根为0
        return 0;
    }

    /**
     * 二分法
     */
    static int LeetCodeSolution(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
