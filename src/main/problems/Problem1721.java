package main.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem1721 {

    public ListNode swapNodes(ListNode head, int k) {
        k = k - 1; // Convert to 0 index

        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode currentNode = head;
        while(currentNode != null) {
            nodes.add(currentNode);
            currentNode = currentNode.next;
        }

        //Account for Wrapping K
        int[] indexes = new int[] {k, (nodes.size() - 1) - k};
        Arrays.sort(indexes);
        ListNode firstNode = nodes.get(indexes[0]);
        ListNode secondNode = nodes.get(indexes[1]);
        if(firstNode == secondNode){
            return head;
        }

        ListNode postFirstNode = nodes.get(indexes[0] + 1);
        ListNode preSecondNode = nodes.get(indexes[1] - 1);

        ListNode preFirstNode = (indexes[0] == 0 ? null : nodes.get(indexes[0] - 1));
        ListNode postSecondNode = (indexes[1] >= nodes.size() - 1 ? null : nodes.get(indexes[1] + 1));

        if(indexes[0] != 0) {
            preFirstNode.next = secondNode;
        } else {
            head = secondNode;
        }

        firstNode.next = postSecondNode;
        secondNode.next = ((postFirstNode == secondNode) ? firstNode : postFirstNode);
        preSecondNode.next = (preSecondNode == firstNode ? preSecondNode.next : firstNode);


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
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
}
