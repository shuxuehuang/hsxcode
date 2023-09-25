package writtenexamination.mihayou;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int h = in.nextInt();
        int[][] cards = new int[n][2];
        for (int i = 0; i < n; i++) {
            cards[i][0] = in.nextInt();
            cards[i][1] = in.nextInt();
        }
        solution(cards, h);
    }
    public static void solution(int[][] cards, int h){
        int n = cards.length;
        double res = 1.0;
        int num = 0;
        for (int[] card : cards){
            int type = card[0];
            int x = card[1];
            if (type == 1){
                num += x;
            }
            if (type == 2){
                h -= x;

            }
        }
    }
}
