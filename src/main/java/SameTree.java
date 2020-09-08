/**
 * 100.【相同的树】
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * [1,2,3],   [1,2,3]
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:      1          1
 * /           \
 * 2             2
 * [1,2],     [1,null,2]
 * 输出: false
 * <p>
 * 示例 3:
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * [1,2,1],   [1,1,2]
 * 输出: false
 */
public class SameTree {
    public static void main(String[] args) {

    }

    static boolean MySolution(TreeNode p, TreeNode q) {

        return true;
    }

    static boolean LeetCodeSolution(TreeNode p, TreeNode q) {

        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
