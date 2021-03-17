package simple;

/**
 * @author Anchor
 *
 * 83.【删除排序链表中的重复元素】
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例1:
 *  输入: 1->1->2
 *  输出: 1->2
 *
 * 示例2:
 *  输入: 1->1->2->3->3
 *  输出: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        System.out.println(LeetCodeSolution(node));
    }

    /**
     * 递归求解
     * 1->1->2->3->3 和 1->1->1->1->1 的不同是递归的参数
     * 如果 l1 == l2，删除 l2 后对 head 进行去重
     * 如果 l1 != l2，对 head.next 进行去重
     */
    static ListNode MySolution(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.val == head.next.val) {
            head.next = head.next.next;
            MySolution(head);
        }else {
            MySolution(head.next);
        }
        return head;
    }

    static ListNode LeetCodeSolution(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + ", " + next;
        }
    }
}
