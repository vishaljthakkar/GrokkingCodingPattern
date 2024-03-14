package com.neetcode.beginners.algods.o15graphs.leetcode;

import java.util.*;

// https://leetcode.com/problems/course-schedule/
public class O6_CourseSchedule_207 {
    public class GraphNode {
        int value;
        int indegree;
        List<GraphNode> neighbors;

        public GraphNode(int value) { this.value= value; this.neighbors = new ArrayList<>(); }

        public int getValue() { return this.value; };
        public int getInDegree() { return this.indegree; }
        public List<GraphNode> getNeighbors() { return this.neighbors; }

        public void incrementInDegree() { this.indegree += 1; }
        public void decrementInDegree() {
            this.indegree -= 1;
            if (this.indegree < 0)  this.indegree = 0;
        }

        public void addNeighbor(GraphNode neighbor) {
            this.neighbors.add(neighbor);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, GraphNode> graph = new HashMap<>();

        // Empty graph nodes
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new GraphNode(i));
        }

        // Add connections
        for(int[] prereq : prerequisites) {
            int src = prereq[1]; int dest = prereq[0];
            graph.get(src).addNeighbor(graph.get(dest));
            graph.get(dest).incrementInDegree();
        }

        // Add nodes which has no incoming edges to the queue.
        Queue<GraphNode> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (graph.get(i).getInDegree() == 0) {
                queue.offer(graph.get(i));
            }
        }

        int courseCount = 0;
        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++) {
                GraphNode currentCourse = queue.poll();
                // We were able to do this course
                courseCount = courseCount + 1;

                for(GraphNode node: currentCourse.getNeighbors()) {
                    // remove the incoming edge coming from the node "currentCourse" to this neighbor
                    // and see if it has no incoming edges.
                    node.decrementInDegree();
                    if (node.getInDegree() == 0) {
                        queue.offer(node);
                    }
                }
            }
        }
        return courseCount == numCourses;
    }

    public static void main(String[] args) {
//        System.out.println(new O6_CourseSchedule_207().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new O6_CourseSchedule_207().canFinish(5,
                new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
    }
}
