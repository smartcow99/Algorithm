import sys
from collections import deque

input = sys.stdin.readline

n, m, v = map(int, input().split())
graph = [[0 for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1

dfs_visited = [0 for _ in range(n+1)]
bfs_visited = [0 for _ in range(n+1)]

def dfs(flag):
    if dfs_visited[flag] == 1:
        return
    dfs_visited[flag] = 1
    print(flag, end=" ")
    for i in range(1, n+1):
        if graph[flag][i] == 1 and dfs_visited[i] == 0:
            dfs(i)

def bfs(flag):
    queue = deque([flag])
    bfs_visited[flag] = 1
    while queue:
        current = queue.popleft()
        print(current, end=" ")
        for i in range(1, n+1):
            if graph[current][i] == 1 and bfs_visited[i] == 0:
                queue.append(i)
                bfs_visited[i] = 1

dfs(v)
print()
bfs(v)
