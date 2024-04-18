# def dfs(triangle, step, idx):
#     if step == len(triangle):
#         return 0
#     return triangle[step][idx] + max(
#         dfs(triangle, step + 1, idx),
#         dfs(triangle, step + 1, idx + 1)
#     )

# def solution(triangle):
#     return triangle[0][0] + max(dfs(triangle, 1, 0), dfs(triangle, 1, 1))

def solution(triangle):
    n = len(triangle)
    dp = [[0] * n for _ in range(n)]
    for i in range(n-1, -1, -1):
        for j in range(i+1):
            if i == n - 1:
                dp[i][j] = triangle[i][j]
            else:
                dp[i][j] = triangle[i][j] + max(dp[i+1][j], dp[i+1][j+1])
    
    return dp[0][0]