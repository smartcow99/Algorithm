class Solution {
    public long solution(int n) {
        int MOD = 1234567;
        long[] dp = new long[n+1];
        if(n <= 2) {
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];   
    }
}

/*
1 : 1
2 : 11, 2
3 : 111, 12, 21
4 : 1111, 112, 121, 211, 22
5 : 11111, 1112, 1121, 1211, 2111, 122, 212, 221
6 : 111111, 11112, 11121, 11211, 12111, 21111, 1122, 1212, 1221, 2121, 2112, 2211, 222
*/