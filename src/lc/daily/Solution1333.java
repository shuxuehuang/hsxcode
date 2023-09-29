package lc.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1333 {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
                if (a[1] == b[1]){
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            });
            for (int[] restaurant : restaurants){
                if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                    queue.offer(new int[]{restaurant[0], restaurant[1]});
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                list.add(queue.poll()[0]);
            }
            return list;
        }
}
