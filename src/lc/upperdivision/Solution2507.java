package lc.upperdivision;
//rating 1500
public class Solution2507 {
    public int smallestValue(int n) {
       while (true){
           int x = n, s = 0, i = 2;
           while (i * i <= x){
               while (x % i == 0){
                   s += i;
                   x /= i;
               }
               i++;
           }
           if (x > 1){
               s += x;
           }
           if (s == n){
               return n;
           }
           n = s;
       }
    }
}
