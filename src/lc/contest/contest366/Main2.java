package lc.contest.contest366;

import java.util.Collections;
import java.util.List;

public class Main2 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int n = processorTime.size();
        int index = 0;
        int res = 0;
        for (int i = n; i >= 0; i--){
            int startTime = processorTime.get(i);
            for (int j = index; j < index + 4; j++) {
                res = Math.max(res, startTime + tasks.get(j));
            }
            index += 4;
        }
        return res;
    }
}
