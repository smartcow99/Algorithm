from collections import deque

def move(n):
    x = [-1, 1, 0, 0]
    y = [0, 0, -1, 1]
    return [x[n], y[n]]

def solution(rectangles, characterX, characterY, itemX, itemY):
    _map = [[0 for _ in range(102)] for _ in range(102)]
    cx, cy = characterX*2, characterY*2
    itemX, itemY = itemX*2, itemY*2
    
    for rec in rectangles:
        x1, y1, x2, y2 = rec
        x1, y1, x2, y2 = x1*2, y1*2, x2*2, y2*2
        for x in range(x1 + 1, x2):
            for y in range(y1 + 1, y2):
                _map[x][y] = 2
        for x in range(x1, x2+1):
            if not _map[x][y1]:
                _map[x][y1] = 1
            if not _map[x][y2]:
                _map[x][y2] = 1
        for y in range(y1, y2+1):
            if not _map[x1][y]:
                _map[x1][y] = 1
            if not _map[x2][y]:
                _map[x2][y] = 1
    
    que = deque([(cx, cy)])
    
    while que:
        cur = que.popleft()
        cx, cy = cur
        
        for i in range(4):
            x, y = move(i)
            nx, ny = cx + x, cy + y
            
            if _map[nx][ny] != 1:
                continue
            _map[nx][ny] = _map[cx][cy] + 1
            que.append((nx, ny))
    return _map[itemX][itemY] // 2
        