package com.neetcode.beginners.algods.o15graphs.leetcode;

import java.util.*;
// https://leetcode.com/problems/course-schedule/
// Same code as before but we are solving without the use of GraphNode
public class O7_CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            int src = prereq[1];
            int dest = prereq[0];
            adj.get(src).add(dest);
            indegree[dest] = indegree[dest] + 1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int courseCompleted = 0;
        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++) {
                int currentCourse = queue.poll();
                courseCompleted = courseCompleted + 1;

                for(int nextCourse : adj.get(currentCourse)) {
                    indegree[nextCourse] = indegree[nextCourse] - 1;
                    if (indegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }
        return courseCompleted == numCourses;
    }
}
