/**
 * 21. Merge Two Sorted Lists (https://leetcode.com/problems/merge-two-sorted-lists/)
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }

            current = current.next;
        }

        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
