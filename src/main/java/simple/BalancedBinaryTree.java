package simple;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anchor
 *
 * 11.【平衡二叉树】
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *    一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 *            3
 *         /    \
 *       9      20
 *             /  \
 *           15    7
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 *              1
 *           /     \
 *         2        2
 *       /  \
 *      3    3
 *     / \
 *   4    4
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 *
 * 提示:
 *     树中的节点数在范围 [0, 5000] 内
 *     -104 <= Node.val <= 104
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode n1 = init1();
        TreeNode n2 = init2();
        System.out.println(isBalanced(n1));
        System.out.println(isBalanced(n2));
    }

    /**
     * 动态规划 + 递归 + 层序遍历获取高度
     */
    public static boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        return adjudicator(root.left, root.right);
    }

    private static boolean adjudicator(TreeNode left, TreeNode right) {
        int l = 0, r = 0;
        if (null != left) l = height(left);
        if (null != right) r = height(right);
        int height = l - r;
        boolean flag = Math.abs(height) - 1 <= 0;
        return flag && adjudicator(left.left, left.right) && adjudicator(right.left, right.right);
    }

    private static int height(TreeNode node) {
        if (null == node) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode n = queue.poll();
                if (null != n.left) queue.add(n.left);
                if (null != n.right) queue.add(n.right);
                size--;
            }
            height++;
        }
        return height;
    }

    private static TreeNode init1() {
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n2 = new TreeNode(20, n3, n4);
        TreeNode n1 = new TreeNode(9);
        return new TreeNode(3, n1, n2);
    }

    private static TreeNode init2() {
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n5, n6);
        TreeNode n4 = new TreeNode(3);
        TreeNode n1 = new TreeNode(2, n3, n4);
        TreeNode n2 = new TreeNode(2);
        return new TreeNode(1, n1, n2);
    }
}
