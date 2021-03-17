package simple;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Anchor
 *
 * 107.【二叉树的层次遍历 II】
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *          3
 *        /   \
 *       9    20
 *           /  \
 *          15   7
 * 返回其自底向上的层次遍历为：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class BiTreeLevelOrderTraversal2 {
    public static void main(String[] args) {
        TreeNode root = initialize();
        System.out.println(MySolution(root));
    }

    /**
     * 层序遍历树，遍历每层时获取当前层的所有结点
     * 用链表将当前层的数据放到链表头部
     */
    public static List<List<Integer>> MySolution(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            result.add(0, level);
        }
        return result;
    }

    private static TreeNode initialize() {
        TreeNode l20 = new TreeNode(15);
        TreeNode l21 = new TreeNode(7);
        TreeNode l10 = new TreeNode(9);
        TreeNode l11 = new TreeNode(20, l20, l21);
        return new TreeNode(3, l10, l11);
    }
}
