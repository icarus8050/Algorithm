/**
 * 83. Remove Duplicates from Sorted List (https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next;
            if (current.val == next.val) {
                current.next = next.next;
            } else {
                current = next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates_2(head.next);
        return head.val == head.next.val ? head.next : head;
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
