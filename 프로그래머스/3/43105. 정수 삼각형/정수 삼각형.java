import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] dp = new int[size][size];
        dp[0][0] = triangle[0][0];
        for (int x = 1; x < size; x++) {
            for (int y = 0; y <= x; y++) {
                if (y == 0) {
                    dp[x][y] = triangle[x][y] + dp[x-1][y];
                } else if (y == x) {
                    dp[x][y] = triangle[x][y] + dp[x-1][y-1];
                } else {
                    dp[x][y] = Math.max(dp[x-1][y], dp[x-1][y-1]) + triangle[x][y];
                }
            }
        }
        int answer = Arrays.stream(dp[size-1]).max().getAsInt();
        return answer;
    }
}