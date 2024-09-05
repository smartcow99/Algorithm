import sys

input = sys.stdin.readline
maxi = 987654321

def dfs(source, goal, depth):
    if depth == maxi:
        return maxi
    if source == goal:
        return depth
    elif source > goal:
        return maxi
    return min(dfs(source*2, B, depth + 1), dfs(source*10+1, B, depth + 1))

A, B = map(int, input().split())
result = min(dfs(A*2, B, 2), dfs(A*10+1, B, 2))
if result == maxi:
    print(-1)
else: 
    print(result)