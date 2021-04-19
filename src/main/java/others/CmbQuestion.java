package others;

/**
 * 招商银行机试题：
 *
 * 小招手上有两个数组，nums 和 values 数组。现小招每次可以从 nums 数组的头部或者尾部取走一个数。
 * 假设第 i 次取的数字为 x，那么第 i 次取的价值为 values[i - 1] * x。
 * 小招现在要把所有 nums 数组里的数字取完，求小招可以取到的最大价值？
 *
 * 示例 1：
 *   输入： [1, 100], [2, 1]
 *   输出： 201
 *   说明： nums 数组里，第一次先取 100，价值为 values[0] * 100 = 200，
 *         第二次取 1，价值为 values[1] * 1 = 1，最大价值为 200 + 1 = 201。
 *
 * 示例 2：
 *   输入： [1, 3, 5, 2, 4], [1, 2, 3, 4, 5]
 *   输出： 52
 *   说明： 第一次从左边取走 nums[0]，价值为：values[0] * num[0] = 1,
 *         第二次从左边取走 nums[1]，价值为：values[1] * num[1] = 6,
 *         第三次从左边取走 nums[4]，价值为：values[2] * num[4] = 12,
 *         第四次从左边取走 nums[3]，价值为：values[3] * num[3] = 8,
 *         第五次从左边取走 nums[2]，价值为：values[4] * num[2] = 25,
 *         总价值为：1 + 6 + 12 + 8 + 25 = 52。
 *
 * 思路：
 *   以示例 2 为例。双路递归求解，从首出发或从尾出发，求出总价值后选两条路中较大的总价值。
 *   子递归同理。用 s = nums.length 来控制递归停止，每下一层，s 减一，s = 1 时递归终止。
 *
 *                                           Max
 *                                /                        \
 *                           1                                 4
 *                       /       \                         /       \
 *                     3          4                      1          2
 *                  /    \      /    \                /    \      /    \
 *                5       4    3      2              3       2    1      5
 *              /  \     / \  / \   /  \            /  \     / \  / \   /  \
 *             2    4   5  2 5  2  3    5          5    2   3  5 3  5  1    3
 *             |    |   |  | |  |  |    |          |    |   |  | |  |  |    |
 *             4    2   2  5 5  2  5    3          2    5   5  3 5  3  3    1
 *
 * 优化空间：
 *   用动态规划求解
 *
 * @author Anchor
 * @date 2021-04-18 14:43
 */
public class CmbQuestion {
    public static void main(String[] args) {
        CmbQuestion solution = new CmbQuestion();
        int[] a = {1, 3, 5, 2, 4};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {1, 100};
        int[] d = {2, 1};
        System.out.println(solution.getMaxValue(a, b));
        System.out.println(solution.getMaxValue(c, d));
    }

    public int getMaxValue(int[] nums, int[] values) {
        if (nums.length == 0 || values.length == 0) return 0;
        int s = nums.length;
        int h = head(0, s - 1, s, nums, values);
        int t = tail(0, s - 1, s, nums, values);
        return Math.max(h, t);
    }

    /**
     * 头递归
     * @param h   headIndex
     * @param t   tailIndex
     * @param s   size
     * @param n   nums 数组
     * @param v   values 数组
     * @return 最大价值
     */
    public int head(int h, int t, int s, int[] n, int[] v) {
        int now = v[v.length - s] * n[h];
        if (s == 1) {
            return now;
        } else {
            // 此时，h 已经计算过了，所以往下一层一定是 h + 1
            int h1 = head(h + 1, t, s - 1, n, v) + now;
            int t1 = tail(h + 1, t, s - 1, n, v) + now;
            return Math.max(h1, t1);
        }
    }

    /**
     * 尾递归
     * @param h   headIndex
     * @param t   tailIndex
     * @param s   size
     * @param n   nums 数组
     * @param v   values 数组
     * @return 最大价值
     */
    public int tail(int h, int t, int s, int[] n, int[] v) {
        int now = v[v.length - s] * n[t];
        if (s == 1) {
            return now;
        } else {
            // 此时，t 已经计算过了，所以往下一层一定是 t - 1
            int h1 = head(h, t - 1, s - 1, n, v) + now;
            int t1 = tail(h, t - 1, s - 1, n, v) + now;
            return Math.max(h1, t1);
        }
    }
}
