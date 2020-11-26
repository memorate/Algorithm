package basis;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *                             二叉树的几种遍历方法
 *
 *                  1                                      1
 *              /      \                               /      \
 *            2         3                             2        3
 *          /  \      /  \                          /   \       \
 *        4     5    6    7                        4     5       6
 *                                                      / \     /
 *                                                     7   8   9
 *             (树 t1)                                   (树 t2)
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
 *
 *   层序遍历：
 *     t1: [1, 2, 3, 4, 5, 6, 7]
 *     t2: [1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
public class BiTreeTraversal {

    static int[] r = new int[9];
    static int counter = 0;
    static TreeNode t1 = new TreeNode();
    static TreeNode t2 = new TreeNode();

    public static void main(String[] args) {
        initialize(t1, t2);

        System.out.println("————————前序遍历————————");
        System.out.print("递归：");
        preOrder(t1);
        System.out.println("  t1——" + print(r));
        preOrder(t2);
        System.out.println("       t2——" + print(r));
        System.out.print("非递归：");
        nonRecursivePreOrder(t1);
        System.out.println("t1——" + print(r));
        nonRecursivePreOrder(t2);
        System.out.println("       t2——" + print(r) + "\n");

        System.out.println("————————中序遍历————————");
        System.out.print("递归：");
        inOrder(t1);
        System.out.println("  t1——" + print(r));
        inOrder(t2);
        System.out.println("       t2——" + print(r));
        System.out.print("非递归：");
        nonRecursiveInOrder(t1);
        System.out.println("t1——" + print(r));
        nonRecursiveInOrder(t2);
        System.out.println("       t2——" + print(r) + "\n");

        System.out.println("————————反中序遍历————————");
        reverseInOrder(t1);
        System.out.println("t1: " + print(r));
        reverseInOrder(t2);
        System.out.println("t2: " + print(r) + "\n");

        System.out.println("————————后序遍历————————");
        System.out.print("递归：");
        postOrder(t1);
        System.out.println("  t1——" + print(r));
        postOrder(t2);
        System.out.println("       t2——" + print(r));
        System.out.print("非递归：");
        nonRecursivePostOrder(t1);
        System.out.println("t1——" + print(r));
        nonRecursivePostOrder(t2);
        System.out.println("       t2——" + print(r) + "\n");

        System.out.println("————————层序遍历————————");
        levelOrder(t1);
        System.out.println("t1: " + print(r));
        levelOrder(t2);
        System.out.println("t2: " + print(r));
    }

    /**
     * 递归前序遍历
     * 根节点 + 左节点 + 右节点
     */
    static void preOrder(TreeNode node) {
        if (null == node) return;
        r[counter++] = node.val;
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 非递归前序遍历
     */
    static void nonRecursivePreOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()){
            while (node != null){
                r[counter++] = node.val;
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 递归中序遍历
     * 左节点 + 根节点 + 右节点
     */
    static void inOrder(TreeNode node) {
        if (null == node) return;
        inOrder(node.left);
        r[counter++] = node.val;
        inOrder(node.right);
    }

    /**
     * 非递归中序遍历
     */
    static void nonRecursiveInOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()){
                node = stack.pop();
                r[counter++] = node.val;
                node = node.right;
            }
        }
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

    /**
     * 非递归后序遍历
     *
     * 双栈法   stack用来遍历树，result用来存储遍历的结果
     * 由于栈的先进后出原则，根节点-右节点-左节点 顺序对树进行遍历，最终取出来的结果则为后序遍历
     */
    static void nonRecursivePostOrder(TreeNode node){
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        while (node != null || !stack.empty()){
            while (node != null){
                stack.add(node);
                result.add(node);
                node = node.right;
            }
            if (!stack.empty()) node = stack.pop().left;
        }
        while (!result.empty()){
            r[counter++] = result.pop().val;
        }
    }

    /**
     * 广度优先遍历（层序遍历）
     * 从上至下、从左至右逐层遍历
     */
    static void levelOrder(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            r[counter++] = current.val;
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
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
