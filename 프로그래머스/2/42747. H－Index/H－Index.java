import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int n = citations.length;
        for (int i = 1; i <= n; i++) {
            if(i <= citations[n-i]) answer++;
        }
        return answer;
    }
}