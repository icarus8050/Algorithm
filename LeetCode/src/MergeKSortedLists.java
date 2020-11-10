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

    /* 재귀를 통한 풀이 */
    public ListNode mergeKLists_2(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e) return lists[s];
        if (s < e) {
            int m = (s + e) / 2;
            ListNode l1 = partion(lists, s, m);
            ListNode l2 = partion(lists, m + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
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
