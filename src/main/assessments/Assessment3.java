package main.assessments;

import java.util.*;

public class Assessment3 {

//    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
//
//If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

    public String reverseStr(String string, int count) {
        StringBuilder totalString = new StringBuilder();
        StringBuilder workingString = new StringBuilder();
        int runningCount = 0;
        boolean reverseMode = true;
        for(int i = 0; i < string.length(); i++) {
            workingString.append(string.charAt(i));
            runningCount++;
            if(runningCount == count) {

                if(reverseMode) {
                    totalString.append(workingString.reverse().toString());
                    reverseMode = false;
                } else {
                    totalString.append(workingString.toString());
                    reverseMode = true;
                }
                runningCount = 0;
                workingString.setLength(0);
            }
        }

        //Flush
        if(reverseMode) {
            totalString.append(workingString.reverse().toString());
            reverseMode = false;
        } else {
            totalString.append(workingString.toString());
            reverseMode = true;
        }

        return totalString.toString();
    }



    public List<List<Integer>> criticalConnections(int nodes, List<List<Integer>> connections) {
        Graph graph = new Graph(nodes);
        for(int i = 0; i < connections.size(); i++) {
            graph.addConnection(connections.get(i));
        }

        return graph.getBridges();
    }

    private class Graph {
        List<List<Integer>> bridges = new ArrayList<>();
        int nodes = 0;
        LinkedList<Integer>[] edges;
        int EMPTY = Integer.MIN_VALUE;
        int time = 0;

        Graph(int nodes) {
            this.nodes = nodes;
            this.edges = new LinkedList[this.nodes];
            for(int i = 0; i < this.nodes; i++) {
                this.edges[i] = new LinkedList();
            }
        }

        public void addConnection(List<Integer> integers) {
            int node1 = integers.get(0);
            int node2 = integers.get(1);
            edges[node1].add(node2);
            edges[node2].add(node1);

        }

        public void findBridges() {
            boolean[] visted = new boolean[nodes];
            int[] disc = new int[nodes];
            int[] low = new int[nodes];
            int[] parent = new int[nodes];

            for(int i  = 0 ; i < nodes; i++) {
                parent[i] = EMPTY;
                visted[i] = false;
            }

            for(int i = 0; i < nodes; i++) {
                if(visted[i] == false) {
                    bridgUtil(i, visted, disc, low, parent);
                }
            }
        }

        private void bridgUtil(int i, boolean[] visted, int[] disc, int[] low, int[] parent) {
            visted[i] = true;
            disc[i] = low[i] = ++time;

            Iterator<Integer> iterator = edges[i].iterator();
            while(iterator.hasNext()) {
                int neighbor = iterator.next();
                if(!visted[neighbor]) {
                    parent[neighbor] = i;
                    bridgUtil(neighbor, visted, disc, low, parent);

                    low[i] = Math.min(low[i], low[neighbor]);
                    if(low[neighbor] > disc[i]) {
                        ArrayList<Integer> con = new ArrayList<>();
                        con.add(i);
                        con.add(neighbor);
                        bridges.add(con);
                    }
                } else if (neighbor != parent[i]) {
                    low[i] =  Math.min(low[i], disc[neighbor]);
                }
            }
        }

        public List<List<Integer>> getBridges() {
            findBridges();
            return bridges;
        }
    }
}
