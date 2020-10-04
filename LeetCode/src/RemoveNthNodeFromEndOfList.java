import java.util.Stack;

/**
 * 19. Remove Nth Node From End of List (https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = head;
        Stack<ListNode> stack = new Stack();
        int listSize;
        int idx = n;

        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }
        stack.push(head);

        listSize = stack.size();

        if (listSize == n) return ans.next;

        while (idx-- > 0)
            head = stack.pop();

        ListNode end = head.next;
        head = stack.pop();
        head.next = end;

        return ans;
    }

    public class ListNode {
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
