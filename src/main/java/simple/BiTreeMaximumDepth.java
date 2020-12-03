package simple;

import common.TreeNode;

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

    /**
     * 当前节点的高度 = 1 + 子树的高度
     *   PS：子树的高度 = Max(左子树, 右子树)
     */
    static int recursion(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(recursion(root.left), recursion(root.right));
    }

    /**
     * 层序遍历树
     *  每遍历一层，depth 加一
     *  每次遍历一层时遍历该层的所有节点
     */
    static int iteration(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            //用size来控制当前层是否遍历结束
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
}
