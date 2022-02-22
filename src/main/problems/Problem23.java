package main.problems;


import main.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {
    PriorityQueue<ListNode> remainingNodes;
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead = null;
        ListNode curNode = null;
        remainingNodes = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return Integer.compare(listNode.val, t1.val);
            }
        });

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                remainingNodes.add(lists[i]);
        }

        if(!remainingNodes.isEmpty()) {
            newHead = remainingNodes.poll();
            curNode = newHead;
            if(curNode.next != null)
                remainingNodes.add(newHead.next);
        }

        while(!remainingNodes.isEmpty()) {
            curNode.next = remainingNodes.poll();
            curNode = curNode.next;
            if(curNode.next != null)
                remainingNodes.add(curNode.next);
        }

        return newHead;
    }
}
