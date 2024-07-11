import sys
from collections import deque

input = sys.stdin.readline

# 입력 받기
n, m = map(int, input().split())
_map = []
target = None

for i in range(n):
    row = list(map(int, input().split()))
    for j in range(m):
        if row[j] == 2:
            target = (i, j)
    _map.append(row)

# 방향 벡터 (상, 하, 좌, 우)
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# BFS 초기화
queue = deque([target])
distances = [[-1] * m for _ in range(n)]
distances[target[0]][target[1]] = 0

# BFS 수행
while queue:
    x, y = queue.popleft()
    
    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        
        if 0 <= nx < n and 0 <= ny < m and _map[nx][ny] == 1 and distances[nx][ny] == -1:
            distances[nx][ny] = distances[x][y] + 1
            queue.append((nx, ny))

# 결과 출력
for i in range(n):
    for j in range(m):
        if _map[i][j] == 0:
            print(0, end=' ')
        else:
            print(distances[i][j], end=' ')
    print()
