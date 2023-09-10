package writtenexamination.rongyao;

import java.util.*;

public class Main2 {
    static List<List<Character>> list = new LinkedList<>();
    static List<Character> path = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        char[] chars = new char[]{'a', 'b', 'c', 'd'};
        backTracking(chars, x, new boolean[4]);
        solution(list);
        System.out.println(list.size());
    }
    public static void solution(List<List<Character>> list){
        Set<Character> res = new HashSet<>();
        char[] chars = new char[]{'a', 'b', 'c', 'd'};

        for (List<Character> lie : list){
            for (int i = 0; i < 4; i++){
                if (lie.contains(chars[i])){

                }
            }
            for (char people : lie){
                if ('a' == people){
                    res.add('a');
                }else if ('b' == people && res.contains('c')){
                    res.remove('c');
                }else if ('c' == people){
                    res.remove('d');
                }else if ('d' == people){
                    res.add('d');
                }
            }
        }
    }
    public static void backTracking(char[] chars, int x, boolean[] isVisited){
        if (path.size() == x){
            list.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (isVisited[i]) continue;
            isVisited[i] =true;
            path.add(chars[i]);
            backTracking(chars, x, isVisited);
            isVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
