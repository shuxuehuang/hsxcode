package lc.daily;

import java.util.*;

/*
* 课程表2，输出拓扑排序
* */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] ans = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int from = p[1];
            int to = p[0];
            graph[from].add(to);
            inDegree[to]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
                onPath[i] = true;
            }
        }

        int count = 0;
        boolean hasCycle = false;

        while (!deque.isEmpty()) {
            int x = deque.poll();
            if (onPath[x]) {
                hasCycle = true;
                return new int[]{};
            }

            ans[count] = x;
            count++;
            for (int next : graph[x]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    onPath[x] = true;
                    deque.offer(next);
                }
            }
        }
        return count == numCourses - 1 ? ans : new int[]{};
    }
}
