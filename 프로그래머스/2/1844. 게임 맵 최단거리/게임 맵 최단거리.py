from collections import deque

def move(num):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    return [dx[num], dy[num]]

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[0 for _ in range(m)] for _ in range(n)]
    visited[0][0] = 1
    que = deque([(0, 0)])
    
    while que:
        cur = que.popleft()
        cx, cy = cur
        
        for i in range(4):
            x, y = move(i)
            nx, ny = cx + x, cy + y
            
            if nx < 0 or nx > n-1 or ny < 0 or ny > m - 1:
                continue
            if not visited[nx][ny] and maps[nx][ny]:
                visited[nx][ny] = visited[cx][cy] + 1
                que.append((nx, ny))
                
    if visited[n-1][m-1] == 0:
        return -1
    return visited[n-1][m-1]