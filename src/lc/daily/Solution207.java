package lc.daily;

import java.util.LinkedList;
import java.util.List;

/*
* 课程表
* */
public class Solution207 {
    boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int [] p : prerequisites){
            int start = p[1];
            int end = p[0];
            graph[start].add(end);
        }
        for (int i = 0; i < numCourses; i++){
            dfs(graph, i, new boolean[numCourses], new  boolean[numCourses]);
        }
        return !hasCycle;
    }
    public void dfs(List<Integer>[] graph, int start, boolean[] isCycle, boolean[] isVisited){
        if (hasCycle){
            return;
        }
        if (isCycle[start]){
            hasCycle = true;
            return;
        }
        if (isVisited[start]){
            return;
        }
        isVisited[start] = true;
        isCycle[start] = true;
        for (int next : graph[start]){
            dfs(graph, next, isCycle, isVisited);
        }
        isCycle[start] = false;
    }
}
