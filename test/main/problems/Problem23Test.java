package main.problems;

import main.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem23Test {

    @Test
    void testStandardSolution() {
        int[][] linkedlistInput = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] input = new ListNode[linkedlistInput.length];
        for(int i = 0; i < linkedlistInput.length; i++) {
            input[i] = ListNode.genLinkedList(linkedlistInput[i]);
        }
        int[] expected = {1,1,2,3,4,4,5,6};

        assertArrayEquals(expected, ListNode.getValues(new Problem23().mergeKLists(input)));
    }

    @Test
    void testStandardEmptyInput() {
        int[][] linkedlistInput = {};
        ListNode[] input = new ListNode[linkedlistInput.length];
        for(int i = 0; i < linkedlistInput.length; i++) {
            input[i] = ListNode.genLinkedList(linkedlistInput[i]);
        }
        int[] expected = {};

        assertArrayEquals(expected, ListNode.getValues(new Problem23().mergeKLists(input)));
    }

    @Test
    void testStandardNullList() {
        int[][] linkedlistInput = {{}};
        ListNode[] input = new ListNode[linkedlistInput.length];
        for(int i = 0; i < linkedlistInput.length; i++) {
            input[i] = ListNode.genLinkedList(linkedlistInput[i]);
        }
        int[] expected = {};

        assertArrayEquals(expected, ListNode.getValues(new Problem23().mergeKLists(input)));
    }

}