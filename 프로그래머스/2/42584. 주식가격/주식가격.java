import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int ii = i + 1; ii < n; ii++) {
                answer[i]++;
                if (prices[i] > prices[ii]) break;
            }
        }
        return answer;
    }
}