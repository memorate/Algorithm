package simple;

/**
 * 70.【爬楼梯】
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *  输入： 2
 *  输出： 2
 *  解释： 有两种方法可以爬到楼顶。
 *   1.  1 阶 + 1 阶
 *   2.  2 阶
 *
 * 示例 2：
 *  输入： 3
 *  输出： 3
 *  解释： 有三种方法可以爬到楼顶。
 *   1.  1 阶 + 1 阶 + 1 阶
 *   2.  1 阶 + 2 阶
 *   3.  2 阶 + 1 阶
 *
 * 可以参考：
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653190796&idx=1&sn=2bf42e5783f3efd03bfb0ecd3cbbc380&chksm=8c990856bbee8140055c3429f59c8f46dc05be20b859f00fe8168efe1e6a954fdc5cfc7246b0&scene=21#wechat_redirect
 */
public class ClimbingStairs {
    public static void main(String[] args) {
//        System.out.println(MySolution1(50));
        System.out.println(MySolution2(50));
    }

    /**
     * 递归，F(n) = F(n - 1) + F(n - 2)
     */
    static int MySolution1(int n) {
        if (n == 0) return 0;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return MySolution1(n - 1) + MySolution1(n - 2);
        }
    }

    /**
     * 自底向上推导 F(n)
     * 用 x、y、z 来缓存 F(n - 2)，F(n - 1)，F(n)
     *
     * n > 46 时结果会溢出
     */
    static int MySolution2(int n) {
        if (n == 0) return 0;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int x = 1, y = 2, z = x + y;   // x = F(n - 2)，y = F(n - 1)，z = F(n)
            for (int i = 3; i < n; i++) {
                x = y;
                y = z;
                z = x + y;
            }
            return z;
        }
    }

    /**
     * 动态规划
     *
     * 你大爷永远是你大爷，比我的更简洁。。。。。阿西吧
     */
    static int LeetCodeSolution(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
