package writtenexamination.xiaomi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static boolean[] onPath;
    static boolean[] isVisited;
    static boolean hasCycle;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        String[] split = s.split(",");
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (String str : split){
            String[] split1 = str.split(":");
            graph[Integer.parseInt(split1[1])].add(Integer.parseInt(split1[0]));
        }
        onPath = new boolean[n];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(graph, i);
        }
        System.out.println(hasCycle ? 0 : 1);
    }
    public static void dfs(List<Integer>[] graph, int start){
        if (onPath[start]){
            hasCycle = true;
            return;
        }
        if (isVisited[start]){
            return;
        }
        onPath[start] = true;
        isVisited[start] = true;
        for (int next : graph[start]){
            dfs(graph, next);
        }
        onPath[start] = false;
    }

}
