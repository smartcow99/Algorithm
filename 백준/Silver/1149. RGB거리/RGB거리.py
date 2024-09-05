import sys
input = sys.stdin.readline

N = int(input())
costs = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * 3 for _ in range(N)]

dp[0][0] = costs[0][0]
dp[0][1] = costs[0][1]
dp[0][2] = costs[0][2]

for i in range(1, N):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]  # 이전 집이 1 또는 2색인 경우
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]  # 이전 집이 0 또는 2색인 경우
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]  # 이전 집이 0 또는 1색인 경우

result = min(dp[N-1][0], dp[N-1][1], dp[N-1][2])
print(result)
