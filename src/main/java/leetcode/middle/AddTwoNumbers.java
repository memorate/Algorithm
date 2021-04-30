package leetcode.middle;

import common.ListNode;

/**
 * 2.【两数相加】
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 * 示例 1：
 *   输入：l1 = [2,4,3], l2 = [5,6,4]
 *   输出：[7,0,8]
 *   解释：342 + 465 = 807.
 *
 * 示例 2：
 *   输入：l1 = [0], l2 = [0]
 *   输出：[0]
 *
 * 示例 3：
 *  输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *   输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *   每个链表中的节点数在范围 [1, 100] 内
 *   0 <= Node.val <= 9
 *   题目数据保证列表表示的数字不含前导零
 *
 * @author Anchor
 * @date 2021-04-30 14:53
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers app = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        app.addTwoNumbers(l1, l2).print();
        ListNode l3 = new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l4 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        app.addTwoNumbers(l3, l4).print();
    }

    /**
     * 思路：
     *      2 4 3
     *    + 5 6 4
     *    ————————
     *      7 0 8
     *  从 l1、l2 的头结点开始往上相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // r 是结果，last 是当前尾结点(用于构造链表)
        ListNode r = null, last = null;
        // 进位
        int carry = 0;
        // 每一次循环，处理一位，从数的尾部位开始处理
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 处理进位
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            // 往链表尾部添加节点
            if (r == null) {
                r = last = new ListNode(sum);
            } else {
                last.next = new ListNode(sum);
                last = last.next;
            }
        }
        // 处理最后一个进位
        if (carry == 1) {
            last.next = new ListNode(1);
        }
        return r;
    }
}
