package simple;

import common.TreeNode;

/**
 * @author Anchor
 *
 * 100.【相同的树】
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *  输入:
 *         1         1
 *        / \       / \
 *       2   3     2   3
 *      [1,2,3],   [1,2,3]
 *  输出: true
 *
 * 示例 2:
 *  输入:
 *         1          1
 *        /           \
 *       2             2
 *      [1,2],     [1,null,2]
 *  输出: false
 *
 * 示例 3:
 *  输入:
 *         1         1
 *        / \       / \
 *       2   1     1   2
 *      [1,2,1],   [1,1,2]
 *  输出: false
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(1);
        TreeNode t1 = new TreeNode(1, t2, t3);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(MySolution(t1, n1));
    }

    /**
     * 递归
     */
    static boolean MySolution(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return MySolution(p.left, q.left) && MySolution(p.right, q.right);
            }
        }
    }

    /**
     * 递归
     */
    static boolean LeetCodeSolution(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return LeetCodeSolution(p.left, q.left) && LeetCodeSolution(p.right, q.right);
        }
    }
}
