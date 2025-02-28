import java.util.Arrays;

class Solution {
    static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            dp[y][x] = -1;
        }

        dp[0][0] = 1;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }
                if (y > 0) dp[y][x] = (dp[y][x] + dp[y - 1][x]) % MOD;
                if (x > 0) dp[y][x] = (dp[y][x] + dp[y][x - 1]) % MOD;
            }
        }

        return dp[n - 1][m - 1];
    }
}
