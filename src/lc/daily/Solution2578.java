package lc.daily;

import com.sun.javaws.Main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2578 {
    class Solution {
        public int splitNum(int num) {
            char[] stnum = Integer.toString(num).toCharArray();
            Arrays.sort(stnum);
            int num1 = 0, num2 = 0;
            for (int i = 0; i < stnum.length; ++i) {
                if (i % 2 == 0) {
                    num1 = num1 * 10 + (stnum[i] - '0');
                } else {
                    num2 = num2 * 10 + (stnum[i] - '0');
                }
            }
            return num1 + num2;
        }
    }
}
