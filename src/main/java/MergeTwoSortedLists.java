/**
 * 【合并两个有序链表】
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：】
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
    }

    /**
     * 递归
     */
    public static ListNode LeetCodeSolution1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = LeetCodeSolution1(l1.next, l2);
            return l1;
        } else {
            l2.next = LeetCodeSolution1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     */
    public ListNode LeetCodeSolution2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    class ListNode{
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
