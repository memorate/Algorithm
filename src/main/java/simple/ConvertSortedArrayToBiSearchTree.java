package simple;

import common.TreeNode;

/**
 * 108.【将有序数组转换为二叉搜索树】
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *    给定有序数组: [-10,-3,0,5,9],
 *
 *    一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *           0
 *         /  \
 *       -3    9
 *       /    /
 *     10    5
 *
 */
public class ConvertSortedArrayToBiSearchTree {

    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        System.out.println(sortedArrayToBST(array));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return null;
    }
}
