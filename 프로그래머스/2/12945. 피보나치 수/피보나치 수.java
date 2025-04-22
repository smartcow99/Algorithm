class Solution {
    public int solution(int n) {
        final int MOD = 1234567;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % MOD;
        }
        return dp[n] % MOD;
    }
}