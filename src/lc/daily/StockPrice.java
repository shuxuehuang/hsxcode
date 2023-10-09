package lc.daily;

import java.util.*;

public class StockPrice {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Integer> priceToNum;

    public StockPrice() {
        map = new TreeMap<>();
        priceToNum = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)){
            Integer oldPrice = map.get(timestamp);
            priceToNum.put(oldPrice, priceToNum.get(oldPrice) - 1);
            if (priceToNum.get(oldPrice) == 0){
                priceToNum.remove(oldPrice);
            }
        }
        map.put(timestamp, price);
        priceToNum.put(price, priceToNum.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(map.lastKey());
    }

    public int maximum() {
        return priceToNum.lastKey();
    }

    public int minimum() {
        return priceToNum.firstKey();
    }
}
