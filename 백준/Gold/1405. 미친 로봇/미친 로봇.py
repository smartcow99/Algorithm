import sys

input = sys.stdin.readline

n, E, W, S, N = map(int, input().split())

dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
probs = [E / 100, W / 100, S / 100, N / 100]

visited = set()

def dfs(x, y, steps, prob):
    if steps == n:
        return prob
    
    visited.add((x, y))
    result = 0
    
    for i in range(4):
        if probs[i] > 0:
            nx, ny = x + dx[i], y + dy[i]
            if (nx, ny) not in visited:
                result += dfs(nx, ny, steps + 1, prob * probs[i])
    
    visited.remove((x, y))
    return result

visited.add((0, 0))
result = dfs(0, 0, 0, 1.0)

print(result)
