package writtenexamination.huawei;


import java.util.*;

public class Main3 {
    static int resStationNum;
    static int resArea;
    static Map<Pair<Integer, Integer> ,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        backTracking(arr, 0, 0, map);
        System.out.println(resStationNum + " " + resArea);
    }
    public static void backTracking(int[][] arr, int startIndex, int stationNum, Map<Pair<Integer, Integer> ,Integer> map){
        if (map.size() >= resArea){
            resArea = Math.max(resArea, map.size());
            resStationNum = stationNum;
        }
        for (int i = startIndex; i < arr.length; i++){
            addArea(map, arr[i][0], arr[i][1]);
            backTracking(arr, i + 1, stationNum + 1, map);
            removeArea(map, arr[i][0], arr[i][1]);
        }
    }
    public static void addArea(Map<Pair<Integer, Integer> ,Integer> map, int x, int y){
        for (int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0){
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    map.put(pair, map.getOrDefault(pair, 0) + 1);
                }
            }
        }
    }
    public static void removeArea(Map<Pair<Integer, Integer> ,Integer> map, int x, int y){
        for (int i = x - 1; i <= x + 1; i++){
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0){
                    Pair<Integer, Integer> pair = new Pair<>(i, j);
                    map.put(pair, map.get(pair) - 1);
                    if (map.get(pair) == 0){
                        map.remove(pair);
                    }
                }
            }
        }
    }

}
class Pair<K, V>{
    K key;
    V value;
    int time;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
        this.time = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
