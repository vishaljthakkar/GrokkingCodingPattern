package com.neetcode.beginners.algods.o15graphs;

import java.util.*;

public class O3AdjacencyList {

    class GraphNode {
        int val;
        List<GraphNode> neighbors;

        public GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }

    public static HashMap<String, List<String>> buildAdjList(String[][] edges) {
        HashMap<String, List<String>> adjList = new HashMap<>();

        for(String[] edge : edges) {
            adjList.put(edge[0], adjList.getOrDefault(edge[0], new ArrayList<String>()));
            adjList.get(edge[0]).add(edge[1]);
        }
        return adjList;
    }

    // Count Paths (Backtracking)
    public static int shortestPathOrLength(String source, String target, Map<String, List<String>> adjList) {
        Set<String> visited = new HashSet<>();
        int count = 0;
//        count = dfsHelper(source, target, adjList, visited);
        count = bfsHelper(source, target, adjList, visited);
        return count;
    }

    public static int dfsHelper(String source, String target,
                                Map<String, List<String>> adjList, Set<String> visited) {

        // Already visited
        if (visited.contains(source)) return 0;
        // Did we reach our target
        if (source.equals(target)) return 1;
        // Start counting in how many ways can we reach the target from this node.
        int count = 0;
        visited.add(source);
        for(String neighbor: adjList.get(source)) {
            count += dfsHelper(neighbor, target, adjList, visited);
        }
        visited.remove(source);
        return count;
    }

    public static int bfsHelper(String source, String target, Map<String, List<String>> adjList, Set<String> visited) {
        int length = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);

        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++) {
                String node = queue.poll();

                if (node != null && node.equals(target)) return length;

                for(String neighbor : adjList.get(node)) {
                    if (visited.contains(neighbor)) continue;
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            length = length + 1;
        }
        return length;
    }



    public static void main(String[] args) {
        String[][] edges = { {"A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E", "D"}, {"C", "B"} };
        HashMap<String, List<String>> adjList = buildAdjList(edges);
        System.out.println(adjList);
        System.out.println(shortestPathOrLength("A", "E", adjList));
    }

}
