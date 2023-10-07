package lc.daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StockSpanner {
    /*private List<Integer> prices;
    private List<Integer> span;
    public StockSpanner() {
        prices = new ArrayList<>();
        span = new ArrayList<>();
    }*/

    /*public int next(int price) {
        if (span.size() == 0){
            prices.add(price);
            span.add(1);
            return 1;
        }
        if (price < prices.get(prices.size() - 1)){
            span.add(1);
            prices.add(price);
            return 1;
        }
        int res = 1;
        int dis = span.get(span.size() - 1);
        res += dis;
        int index = span.size() - 1 - dis;
        for (int i = index; i >= 0 ; i--) {
            if (price >= prices.get(i)){
                res++;
            }else{
                break;
            }
        }
        span.add(res);
        prices.add(price);
        return res;
    }*/
    private Deque<int[]> stack;
    int idx;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx ++;

        while (!stack.isEmpty() && stack.peek()[1] <= price){
            stack.pop();
        }
        int res = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return res;
    }
}
