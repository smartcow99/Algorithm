import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return answer;
    }
    public void dfs(int sum, int cur, int target, int[] numbers) {
        if (cur == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(sum + numbers[cur], cur + 1, target, numbers);
        dfs(sum - numbers[cur], cur + 1, target, numbers);
        return;
    }
}