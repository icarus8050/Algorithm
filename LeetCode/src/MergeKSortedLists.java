/**
 * 23. Merge k Sorted Lists (https://leetcode.com/problems/merge-k-sorted-lists/)
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode result = null;

        for (ListNode list : lists) {
            ListNode dummy = new ListNode();
            ListNode current = dummy;

            while (result != null && list != null) {
                if (result.val > list.val) {
                    current.next = new ListNode(list.val);
                    list = list.next;
                } else {
                    current.next = new ListNode(result.val);
                    result = result.next;
                }
                current = current.next;
            }

            while (result != null) {
                current.next = new ListNode(result.val);
                result = result.next;
                current = current.next;
            }

            while (list != null) {
                current.next = new ListNode(list.val);
                list = list.next;
                current = current.next;
            }

            result = dummy.next;
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
