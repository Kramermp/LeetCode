package main.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem19Test {

    @Test
    void removeNthFromEndStandard() {
        Problem19.ListNode head = buildList(5);

        Problem19.ListNode result = new Problem19().removeNthFromEnd(head, 2);

        assertEquals("1 2 3 5", Problem19.nodesToString(result));
    }

    @Test
    void removeNthFromEndRemoveHead() {
        Problem19.ListNode head = buildList(5);

        Problem19.ListNode result = new Problem19().removeNthFromEnd(head, 5);

        assertEquals("2 3 4 5", Problem19.nodesToString(result));
    }

    @Test
    void removeNthFromEndRemoveTail() {
        Problem19.ListNode head = buildList(2);

        Problem19.ListNode result = new Problem19().removeNthFromEnd(head, 1);

        assertEquals("1", Problem19.nodesToString(result));
    }

    @Test
    void removeNthFromEndSingle() {
        Problem19.ListNode head = buildList(1);

        Problem19.ListNode result = new Problem19().removeNthFromEnd(head, 1);

        assertEquals("", Problem19.nodesToString(result));
    }

    Problem19.ListNode buildList(int size) {
        Problem19.ListNode head = new Problem19.ListNode(1);
        Problem19.ListNode previousNode = head;


        for(int i = 1; i < size; i++) {
            previousNode.next = new Problem19.ListNode(i + 1);
            previousNode = previousNode.next;
        }

        return head;
    }


}