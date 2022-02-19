package main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Problem1761 {
    GraphNode[] nodes;
    boolean trioFound = false;
    int curMin = Integer.MAX_VALUE;
    int checksTotal = 0;

    public int minTrioDegree(int n, int[][] edges) {
         nodes = new GraphNode[n];
         for(int i = 0; i < n; i++) {
             nodes[i] = new GraphNode(i + 1);
         }
         for(int i = 0; i < edges.length; i++) {
             int[] curCon = edges[i];
             nodes[curCon[0] - 1].addNeighbor(nodes[curCon[1] - 1]);
             nodes[curCon[0] - 1].checksRequired++;
             nodes[curCon[1] - 1].addNeighbor(nodes[curCon[0] - 1]);
             nodes[curCon[1] - 1].checksRequired++;
         }

         for(int i = 0; i < nodes.length; i++) {
             if (nodes[i].checksRequired == 1) {
                 nodes[i].checksRequired = 0;

             } else {
                 checksTotal+=nodes[i].checksRequired;
             }
         }
         System.out.println(("Total Expected Checks:" + checksTotal));

         for(int i = 0; i < nodes.length; i++) {
             if(nodes[i].checksRequired > 0) {
                 checkForTrio(nodes[i]);
                 checksTotal-=nodes[i].checksRequired;
                 nodes[i].checksRequired = 0;
                 System.out.println(checksTotal);
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

    private void checkForTrio(GraphNode node) {
        GraphNode curNeighbor;
        for(int i = 0; i < node.neighborList.size(); i++) {
            curNeighbor = node.neighborList.get(i);
            if(curNeighbor.checksRequired > 0 && curNeighbor.neighborList.size() >= 2) {
                node.findTrios(curNeighbor);
            }
        }
    }

    protected class GraphNode implements Comparable<GraphNode> {
        int id = 0;
        ArrayList<GraphNode> neighborList = new ArrayList<GraphNode>();
        int checksRequired = 0;

        GraphNode(int id) {
            this.id = id;
        }

        public void addNeighbor(GraphNode i) {
            neighborList.add(i);
        }

        public void printNeightborList() {
            GraphNode[] array = new GraphNode[neighborList.size()];
            System.out.println(Arrays.toString(neighborList.toArray(array)));
        }

        public String toString() {
            return String.valueOf(id);
        }

        public void findTrios(GraphNode second) {
            GraphNode curNode;
            second.checksRequired--;
            checksTotal--;
            for(int i = 0; i < second.neighborList.size(); i++) {
                curNode = second.neighborList.get(i);
                if(curNode.checksRequired > 0 && curNode.hasNeighbor(this) && curNode.neighborList.size() >= 2) {
                    trioFound = true;
                    curMin = Math.min(getDegree(this, second, curNode), curMin);
                }
            }
        }

        public boolean hasNeighbor(GraphNode node) {
            return neighborList.contains(node);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof GraphNode) {
                return ((GraphNode) o).id == this.id;
            }
            return false;
        }

        @Override
        public int compareTo(GraphNode graphNode) {
            return Integer.compare(checksRequired, graphNode.checksRequired);
        }

        public int getDegree(GraphNode p0, GraphNode p1, GraphNode p2) {
            int score = 0;
            score += (p0.neighborList.size()) - 2;
            score += (p1.neighborList.size()) - 2;
            score += (p2.neighborList.size()) - 2;
            return score;
        }
    }
}
