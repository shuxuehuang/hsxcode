package codetemplate;

import java.util.Scanner;

public class KMP {
    static char[] s, p;
    static int[] next = new int[100000];

    public static void main(String[] args) {
        input();
        buildNext();
        search();
    }
    static void input(){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String pat = in.next();
        s = str.toCharArray();
        p = pat.toCharArray();
    }
    public static void buildNext(){
        int i = 1, now = 0;
        while (i < p.length){
            if (p[i] == p[now]){
                now++;
                next[i] = now;
                i++;
            }else if (now != 0){
                now = next[now - 1];
            }else {
                i++;
                next[i] = now;
            }
        }
    }
    public static void search() {
        int tar = 0, pos = 0;
        while (tar < s.length){
            if (s[tar] == p[pos]){
                tar++;
                pos++;
            }else if (pos != 0){
                pos = next[pos - 1];
            }else {
                tar++;
            }
            if (pos == p.length) {
                System.out.println(tar - pos);
                pos = next[pos - 1];
            }
        }
    }
}
