package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1721Test {

    @Test
    void swapNodesOdd() {
        Problem1721.ListNode head = buildList(5);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 2);

        assertEquals("1 4 3 2 5", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesEnds() {
        Problem1721.ListNode head = buildList(5);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 1);

        assertEquals("5 2 3 4 1", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesMid() {
        Problem1721.ListNode head = buildList(10);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 5);

        assertEquals("1 2 3 4 6 5 7 8 9 10", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesSingle() {
        Problem1721.ListNode head = buildList(1);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 1);

        assertEquals("1", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesTrip() {
        Problem1721.ListNode head = buildList(3);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 2);

        assertEquals("1 2 3", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesEndWrap() {
        Problem1721.ListNode head = buildList(2);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 2);

        assertEquals("2 1", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesWrap() {
        Problem1721.ListNode head = buildList(9);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 7);

        assertEquals("1 2 7 4 5 6 3 8 9", Problem1721.nodesToString(curHead));
    }

    @Test
    void swapNodesWrap2() {
        Problem1721.ListNode head = buildList(13);

        Problem1721.ListNode curHead = new Problem1721().swapNodes(head, 12);

        assertEquals("1 12 3 4 5 6 7 8 9 10 11 2 13", Problem1721.nodesToString(curHead));
    }

    Problem1721.ListNode buildList(int size) {
        Problem1721.ListNode head = new Problem1721.ListNode(1);
        Problem1721.ListNode previousNode = head;


        for(int i = 1; i < size; i++) {
            previousNode.next = new Problem1721.ListNode(i + 1);
            previousNode = previousNode.next;
        }

        return head;
    }
}