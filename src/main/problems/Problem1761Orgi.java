package main.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem1761Orgi {
    ArrayList<Integer>[] nodes;
    boolean[] searched;
    boolean trioFound = false;
    int curMin = Integer.MAX_VALUE;

    public int minTrioDegree(int n, int[][] edges) {
         nodes = new ArrayList[n];
         searched = new boolean[n];
         for(int i = 0; i < n; i++) {
             nodes[i] = new ArrayList<>();
         }

         for(int i = 0; i < edges.length; i++) {
             int[] curCon = edges[i];
             nodes[curCon[0] - 1].add(curCon[1] - 1);
             nodes[curCon[1] - 1].add(curCon[0] - 1);
         }

         for(int i = 0; i < nodes.length; i++) {
             if(nodes[i].size() > 1) {
                 checkForTrio(i);
                 searched[i] = true;
                 if(curMin == 0) {
                     return 0;
                 }
             }
         }
         if(!trioFound) {
             curMin = -1;
         }
         return curMin;
    }

    private void checkForTrio(int source) {
        // Source = Current Node
        int curNeighbor;
        int[] overlap;
        for(int i = 0; i < nodes[source].size(); i++) {
            curNeighbor = nodes[source].get(i);
            overlap = findOverLap(source, curNeighbor);
            if(overlap != null) {
                for(int j = 0; j < overlap.length; j++) {
                    getDegree(source, curNeighbor, overlap[i]);
                }
            }
        }
    }

    public int[] findOverLap(int source, int neighbor) {
        int[] arr1 = Arrays.stream(new Integer[nodes[source].size()]).mapToInt(Integer::intValue).toArray();
        int[] arr2 = Arrays.stream(new Integer[nodes[neighbor].size()]).mapToInt(Integer::intValue).toArray();

        return Arrays.stream(arr1)
                .distinct()
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .toArray();
    }

    public int getDegree(int p0, int p1, int p2) {
        int score = 0;
        score += nodes[p0].size() - 2;
        score += nodes[p1].size() - 2;
        score += nodes[p2].size() - 2;
        return score;
    }
}
