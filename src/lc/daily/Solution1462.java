package lc.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* 课程表
* */
public class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites){
            graph[p[0]].add(p[1]);
        }
        List<Boolean> res = new LinkedList<>();
        boolean[] isVisited = new boolean[numCourses];
        for (int[] query : queries){
            res.add(dfs(graph, query[0], query[1], isVisited));
        }

        return res;
    }
    public boolean dfs(List<Integer>[] graph, int start, int end, boolean[] isVisited){
        if (start == end){
            return true;
        }
        if (start >= graph.length || isVisited[start]){
            return false;
        }
        isVisited[start] = true;
        boolean res = false;
        for (int next : graph[start]){
            res = res || dfs(graph, next, end, isVisited);
        }
        return res;
    }
}
