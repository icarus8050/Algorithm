/**
 * 24. Swap Nodes in Pairs (https://leetcode.com/problems/swap-nodes-in-pairs/submissions/)
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(
                                3,
                                new ListNode(4)
                        )
                )
        );

        ListNode listNode = swapPairs(head);
        System.out.println("asdfasdf");
    }

    public static ListNode swapPairs(ListNode head) {
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

    private static void swap(ListNode temp) {
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
