package main.problems;

import main.common.ListNode;

public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if(head == null || head.next  == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode temp = newHead.next;
        newHead.next = head;
        head.next = helper(temp);
        return newHead;
    }
}
