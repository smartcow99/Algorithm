from collections import deque

def bfs(graph, start, visit):
    que = deque([start])
    while que:
        v = que.popleft()
        for i in range(len(graph)):
            if graph[v][i] == 1 and not visit[i]:
                visit[i] = True
                que.append(i)

def solution(n, computers):
    cnt = 0
    visit = [False] * n
    for i in range(n):
        if not visit[i]:
            bfs(computers, i, visit)
            cnt += 1
    return cnt