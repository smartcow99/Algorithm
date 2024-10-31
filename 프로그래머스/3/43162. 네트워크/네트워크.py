from collections import deque

def solution(n, computers):
    answer = 0
    visited = [0 for _ in range(n)]
    deq = deque()
    for i in range(n):
        if visited[i] == 1:
            continue
        deq.append(i)
        answer += 1
        while deq:
            target = deq.popleft()
            for j in range(n):
                if computers[target][j] == 1 and visited[j] == 0:
                    visited[j] = 1
                    deq.append(j)
                    
    return answer