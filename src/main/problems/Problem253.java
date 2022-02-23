package main.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Problem253 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals.length;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, (a, b) -> Integer.compare(a, b));
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        allocator.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

}
