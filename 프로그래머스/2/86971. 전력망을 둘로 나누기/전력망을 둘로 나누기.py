from collections import deque

def solution(n, wires):
    connections = [[] for _ in range(n + 1)]
    for a, b in wires:
        connections[a].append(b)
        connections[b].append(a)
        
    def bfs(start, exclude):
        visited = [False] * (n + 1)
        queue = deque([start])
        visited[start] = True
        count = 1
        
        while queue:
            node = queue.popleft()
            for neighbor in connections[node]:
                if neighbor != exclude and not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append(neighbor)
                    count += 1
        return count
    
    imbalance = float('inf')
    for wire in wires:
        count_a = bfs(wire[0], wire[1])
        count_b = bfs(wire[1], wire[0])
        imbalance = min(imbalance, abs(count_a - count_b))
        if imbalance == 0:
            return 0
            
    return imbalance
