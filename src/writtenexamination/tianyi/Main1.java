package writtenexamination.tianyi;

import java.util.Arrays;
import java.util.HashSet;

public class Main1 {
    public int myCount (String str) {
        // write code here
        HashSet<Character> set1 = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u'));

        HashSet<Character> set2 = new HashSet<>(
                Arrays.asList('A', 'E', 'I', 'O', 'U'));
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z' && set1.contains(c)){
                res++;
            }
            if (c >= 'A' && c <= 'Z' && !set2.contains(c)){
                res++;
            }
        }
        return res;
    }
}
