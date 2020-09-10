package basis;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的几种遍历
 *                  1                                      1
 *              /      \                               /      \
 *            2         3                             2        3
 *          /  \      /  \                          /   \       \
 *        4     5    6    7                        4     5       6
 *                                                      / \     /
 *                                                     7   8   9
 *              (树t1)                                    (树t2)
 *
 * 深度优先遍历：
 *   前序遍历：
 *     t1: [1, 2, 4, 5, 3, 6, 7]
 *     t2: [1, 2, 4, 5, 7, 8, 3, 6, 9]
 *
 *   中序遍历：
 *     t1: [4, 2, 5, 1, 6, 3, 7]
 *     t2: [4, 2, 7, 5, 8, 1, 3, 9, 6]
 *
 *   反中序遍历：
 *     t1: [7, 3, 6, 1, 5, 2, 4]
 *     t2: [6, 9, 3, 1, 8, 5, 7, 2, 4]
 *
 *   后序遍历：
 *     t1: [4, 5, 2, 6, 7, 3, 1]
 *     t2: [4, 7, 8, 5, 2, 9, 6, 3, 1]
 */
public class BinaryTreeTraversal {

    static int[] r = new int[9];
    static int counter = 0;
    static TreeNode t1 = new TreeNode();
    static TreeNode t2 = new TreeNode();

    public static void main(String[] args) {
        initialize(t1, t2);

        System.out.println("前序遍历：");
        preOrder(t1);
        System.out.println("t1: " + print(r));
        preOrder(t2);
        System.out.println("t2: " + print(r) + "\n");

        System.out.println("中序遍历：");
        inOrder(t1);
        System.out.println("t1: " + print(r));
        inOrder(t2);
        System.out.println("t2: " + print(r) + "\n");

        System.out.println("反中序遍历：");
        reverseInOrder(t1);
        System.out.println("t1: " + print(r));
        reverseInOrder(t2);
        System.out.println("t2: " + print(r) + "\n");

        System.out.println("后序遍历：");
        postOrder(t1);
        System.out.println("t1: " + print(r));
        postOrder(t2);
        System.out.println("t2: " + print(r));
    }

    /**
     * 前序遍历
     * 根节点 + 左节点 + 右节点
     */
    static void preOrder(TreeNode node) {
        if (null == node) return;
        r[counter++] = node.val;
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * 左节点 + 根节点 + 右节点
     */
    static void inOrder(TreeNode node) {
        if (null == node) return;
        inOrder(node.left);
        r[counter++] = node.val;
        inOrder(node.right);
    }

    /**
     * 反中序遍历
     * 右节点 + 根节点 + 左节点
     */
    static void reverseInOrder(TreeNode node) {
        if (null == node) return;
        reverseInOrder(node.right);
        r[counter++] = node.val;
        reverseInOrder(node.left);
    }

    /**
     * 后序遍历
     * 左节点 + 右节点 + 根节点
     */
    static void postOrder(TreeNode node) {
        if (null == node) return;
        postOrder(node.left);
        postOrder(node.right);
        r[counter++] = node.val;
    }

    static void levelOrder(TreeNode node){
        Queue<TreeNode> q = new LinkedList();
        q.add(node);
        while (!q.isEmpty()){
            r[counter++] = q.poll().val;
        }
    }

    static void initialize(TreeNode t1, TreeNode t2) {
        t1.val = t2.val = 1;

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);
        t1.left = n2;
        t1.right = n3;

        TreeNode m4 = new TreeNode(4);
        TreeNode m6 = new TreeNode(6);
        TreeNode m7 = new TreeNode(7);
        TreeNode m8 = new TreeNode(8);
        TreeNode m5 = new TreeNode(5, m7, m8);
        TreeNode m9 = new TreeNode(9);
        TreeNode m2 = new TreeNode(2, m4, m5);
        TreeNode m3 = new TreeNode(3);
        m3.right = m6;
        m6.left = m9;
        t2.left = m2;
        t2.right = m3;
    }

    static String print(int[] array) {
        String out = "[";
        for (int i : array) {
            out = i == 0 ? out + "" : out + i + ", ";
        }
        clear();
        return out.substring(0, out.lastIndexOf(',')) + "]";
    }

    static void clear() {
        counter = 0;
        r = new int[9];
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
