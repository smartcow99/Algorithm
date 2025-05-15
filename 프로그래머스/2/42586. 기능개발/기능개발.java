import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int idx = 0;

        while (idx < n) {
            for (int i = 0; i < n; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }

            int count = 0;
            while (idx < n && progresses[idx] >= 100) {
                count++;
                idx++;
            }

            if (count > 0) {
                answer.add(count);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
