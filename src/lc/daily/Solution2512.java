package lc.daily;

import java.util.*;

public class Solution2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negetiveSet = new HashSet<>(Arrays.asList(negative_feedback));
        int n = student_id.length;
        int[] grade = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String re = report[student_id[i]];
            String[] words = re.split(" ");
            for (String word : words){
                if (positiveSet.contains(word)){
                    grade[i] += 3;
                }else if (negetiveSet.contains(word)){
                    grade[i] -= 1;
                }
            }
        }
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = i;
        }
        Arrays.sort(temp, (a, b) -> {
            if (grade[b] != grade[a]){
                return grade[b] - grade[a];
            }else {
                return student_id[a] - student_id[b];
            }

        });
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            list.add(student_id[temp[i]]);
        }
        return list;
    }
}
