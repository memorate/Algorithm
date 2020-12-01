package simple;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101.【对称二叉树】
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node1 = initialize1();
        TreeNode node2 = initialize2();
        System.out.println("————————————————Recursion————————————————");
        System.out.println("tree1: " + recursion(node1));
        System.out.println("tree2: " + recursion(node2));
        System.out.println("————————————————Iteration————————————————");
        System.out.println("tree1: " + iteration(node1));
        System.out.println("tree2: " + iteration(node2));
    }

    /**
     * 递归求解
     */
    static boolean recursion(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    /**
     * 迭代求解
     */
    static boolean iteration(TreeNode root) {
        if (root == null) return true;
        return verify(root.left, root.right);
    }

    private static boolean verify(TreeNode first, TreeNode second) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(first);
        queue.add(second);
        //每次判断两个结点
        while (!queue.isEmpty()) {
            first = queue.poll();
            second = queue.poll();
            if (first == null && second == null) continue;
            if (first == null || second == null || first.val != second.val) return false;
            queue.add(first.left);
            queue.add(second.right);
            queue.add(second.left);
            queue.add(first.right);
        }
        return true;
    }

    private static TreeNode initialize1() {
        TreeNode root = new TreeNode(1);
        TreeNode l10 = new TreeNode(2);
        TreeNode l11 = new TreeNode(2);
        TreeNode l20 = new TreeNode(3);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(4);
        TreeNode l23 = new TreeNode(3);
        l10.left = l20;
        l10.right = l21;
        l11.left = l22;
        l11.right = l23;
        root.left = l10;
        root.right = l11;
        return root;
    }

    private static TreeNode initialize2() {
        TreeNode root = new TreeNode(1);
        TreeNode l10 = new TreeNode(2);
        TreeNode l11 = new TreeNode(2);
        TreeNode l21 = new TreeNode(3);
        TreeNode l23 = new TreeNode(3);
        l10.left = null;
        l10.right = l21;
        l11.left = null;
        l11.right = l23;
        root.left = l10;
        root.right = l11;
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
