package basis;

/**
 *             递归与迭代
 * 递归：在方法的定义中调用自身的方法（A调用A）
 * 迭代：循环过程中，上一次循环的结果作为下一次循环的输入（A重复调用B）
 *
 * 以斐波那契数列为例
 *   f(n) = 1, n == 1 || n == 2
 *   f(n) = f(n - 1) + f(n - 2), n > 2
 */
public class RecursionAndIteration {
    public static void main(String[] args) {
        System.out.println(recursion(10));
        System.out.println(iteration(10));
    }

    static int recursion(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return recursion(n - 1) + recursion(n - 2);       //自己调用自己
    }

    static int iteration(int n) {
        if (n == 0) return 0;
        int r = 1, pre = 1, post = 1;         //r：f(n), pre:f(n-2), post:f(n-1)
        for (int i = 2; i < n; i++) {         //储存上一次迭代的结果（pre、post），用于下一次迭代
            r = pre + post;
            pre = post;
            post = r;
        }
        return r;
    }
}
