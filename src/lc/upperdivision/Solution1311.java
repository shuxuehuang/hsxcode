package lc.upperdivision;

import algo.tree.BinaryTree;

import java.util.*;
import java.util.logging.Level;
//rating1653
public class Solution1311 {
    /*public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> hasSearch = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        Set<Integer> ids = new HashSet<>();
        Set<Integer> friend = new HashSet<>();
        ids.add(id);
        while (level > 0){
            friend.clear();
            for (int i : ids) {
                if (hasSearch.contains(i)) continue;
                hasSearch.add(i);
                for (int x : friends[i]){
                    friend.add(x);
                }
            }
            ids.addAll(friend);
            level--;
        }
        Set<String> videos = new HashSet<>();
        for (int i : friend){
            if (i == id) continue;
            videos.addAll(watchedVideos.get(i));
            for (String video : watchedVideos.get(i)){
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        LinkedList<String> res = new LinkedList<>(videos);
        Collections.sort(res, (a, b) -> {
            if (map.get(a) == map.get(b)){
                return a.compareTo(b);
            }else {
                return map.get(a) - map.get(b);
            }
        });
        return res;
    }*/
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++){
            for(int fri : friends[i]){
                graph[i].add(fri);
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        boolean[] isVisited = new boolean[n];

        int step = 0;
        while (!queue.isEmpty()){
            if (step == level) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                for (int next : graph[x]){
                    if (!isVisited[next]){
                        isVisited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        Set<String> set = new HashSet<>();
        while (!queue.isEmpty()){
            Integer x = queue.poll();
            set.addAll(watchedVideos.get(x));
            for (String video : watchedVideos.get(x)){
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }
        LinkedList<String> res = new LinkedList<>(set);
        Collections.sort(res, (a, b) -> {
            if (map.get(a) == map.get(b)){
                return a.compareTo(b);
            }else {
                return map.get(a) - map.get(b);
            }
        });
        return res;
    }
}
