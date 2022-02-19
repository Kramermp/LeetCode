package main.problems;

import java.util.ArrayList;

public class Problem19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode currentNode = head;
        while(currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }

        //Removing Head
        if(n == nodes.size()) {
            return n == 1 ? null : nodes.get(1);

        //Removing Tail Branch
        } else if (n == 1){
            nodes.get(nodes.size() - (n + 1)).next = null;

        //Standard Removal
        } else {
            nodes.get(nodes.size() - (n + 1)).next = nodes.get(nodes.size() - (n - 1));
        }


        return head;
    }

    public static String nodesToString(ListNode head) {
        if(head == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            ListNode curNode = head;
            sb.append(head.val);
            curNode = head.next;

            while (curNode != null) {
                sb.append(" " + curNode.val);
                curNode = curNode.next;
            }
            return sb.toString();
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }}
    }
