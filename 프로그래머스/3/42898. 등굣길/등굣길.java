class Solution {
    final static int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        // dp 배열 초기화 (n+1, m+1 크기)
        int[][] dp = new int[n + 1][m + 1];
        
        // 물에 잠긴 지역 처리 (dp 배열에서 해당 위치는 0으로 설정)
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;  // 물에 잠긴 위치는 -1로 표시
        }
        
        // 첫 번째 칸 (1, 1)은 시작점이므로 1로 설정
        dp[1][1] = 1;

        // DP 배열을 계산 (동적 계획법)
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                // 첫 번째 칸은 이미 초기화되어 있으므로 제외하고 계산
                if (y == 1 && x == 1) continue;

                // 물에 잠긴 지역은 지나갈 수 없음 (dp[x][y] = 0)
                if (dp[y][x] == -1) {
                    dp[y][x] = 0;
                    continue;
                }

                // 왼쪽과 위쪽에서 올 수 있는 경로의 합
                int left = (x > 1) ? dp[y][x - 1] : 0;  // 왼쪽에서 올 수 있는 경로
                int up = (y > 1) ? dp[y - 1][x] : 0;  // 위쪽에서 올 수 있는 경로

                // 두 경로의 합을 MOD로 나누어 저장
                dp[y][x] = (left + up) % MOD;
            }
        }

        // 마지막 칸 (학교 위치)의 경로 수 반환
        return dp[n][m];
    }
}
