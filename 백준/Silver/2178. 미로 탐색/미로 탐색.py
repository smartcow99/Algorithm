import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
maps = [list(map(int, list(input().strip()))) for _ in range(N)]

que = deque()
que.append((0, 0))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

while que:
    x, y = que.popleft()

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and maps[nx][ny] == 1:
            maps[nx][ny] = maps[x][y] + 1
            que.append((nx, ny))

print(maps[N-1][M-1])
