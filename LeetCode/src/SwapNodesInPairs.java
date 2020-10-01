/**
 * 24. Swap Nodes in Pairs (https://leetcode.com/problems/swap-nodes-in-pairs/submissions/)
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode temp = dummy;
        while (true) {
            if (temp.next != null && temp.next.next != null) {
                swap(temp);
                temp = temp.next.next;
            } else break;
        }

        return dummy.next;
    }

    /**
     * Recursive를 이용한 풀이
     */
    public ListNode swapPairsForRecursive(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairsForRecursive(head.next.next);
        n.next = head;
        return n;
    }

    private void swap(ListNode temp) {
        ListNode first = temp.next;
        ListNode second = first.next;
        first.next = second.next;
        second.next = first;
        temp.next = second;
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
