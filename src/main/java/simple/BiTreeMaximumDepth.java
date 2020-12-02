package simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.【二叉树的最大深度】
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *         3
 *       /   \
 *      9    20
 *          /  \
 *         15   7
 * 返回它的最大深度 3 。
 */
public class BiTreeMaximumDepth {

    public static void main(String[] args) {
        TreeNode root = initialize();
        System.out.println("Recursion: " + recursion(root));
        System.out.println("Iteration: " + iteration(root));
    }

    static int recursion(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(recursion(root.left), recursion(root.right));
    }

    static int iteration(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            depth++;
        }
        return depth;
    }

    private static TreeNode initialize() {
        TreeNode l20 = new TreeNode(15);
        TreeNode l21 = new TreeNode(7);
        TreeNode l10 = new TreeNode(9);
        TreeNode l11 = new TreeNode(20, l20, l21);
        return new TreeNode(3, l10, l11);
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
