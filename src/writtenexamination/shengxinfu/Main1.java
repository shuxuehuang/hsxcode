package writtenexamination.shengxinfu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= y; i++) {
            int temp = (int)(Math.pow(x, i) % 10);
            if (list.contains(temp)){
                break;
            }
            list.add(temp);
        }
        System.out.println(list.get(y % list.size()));
    }
}
