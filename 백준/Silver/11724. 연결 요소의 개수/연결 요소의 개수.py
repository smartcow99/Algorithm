import sys
from collections import deque


input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[0 for _ in range(N+1)] for _ in range(N+1)]

for _ in range(M):
  x, y = map(int, input().split())
  graph[x][y] = 1
  graph[y][x] = 1

visited = [0 for _ in range(N+1)]
result = 0

def bfs(flag):
  global result

  queue = deque([flag])
  if visited[flag]:
    return
  
  visited[flag] = 1

  while queue:
    cur = queue.popleft()
    for i in range(1, N+1):
      if graph[cur][i] == 1 and visited[i] == 0:
        queue.append(i)
        visited[i] = 1


for i in range(1, N+1):
  if not visited[i]:
    bfs(i)
    result += 1

print(result)