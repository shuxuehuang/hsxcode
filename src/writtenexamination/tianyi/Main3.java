package writtenexamination.tianyi;

import java.util.HashSet;
import java.util.Set;

public class Main3 {

    public int countSubstring (String a, String b) {
        // write code here
        Set<String> set = new HashSet<>();
        int res = 0;
        int n = a.length();
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n - i; j++){
                String substring = a.substring(j, j + i);
                if (b.contains(substring)){
                    set.add(substring);
                }
            }
        }
        return set.size();
    }

}
