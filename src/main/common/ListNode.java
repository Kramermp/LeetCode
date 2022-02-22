package main.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode genLinkedList(int[] srcValues) {
        if(srcValues.length == 0)
            return null;

        ListNode head  = new ListNode(srcValues[0]);
        ListNode curNode = head;
        for(int i = 1; i < srcValues.length; i++) {
            curNode.next = new ListNode(srcValues[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public static int[] getValues(ListNode head) {
        if(head == null)
            return new int[0];

        ArrayList<Integer> results = new ArrayList<>();
        ListNode curNode = head;
        while(curNode != null) {
            results.add(curNode.val);
            curNode = curNode.next;
        }
        return results.stream().mapToInt(i -> i).toArray();
    }
}
