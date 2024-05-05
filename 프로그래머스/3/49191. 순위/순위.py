def solution(n, results):
    members = [[0 for _ in range(n+1)] for _ in range(n+1)]
    for res in results:
        members[res[0]][res[1]] = 1
        members[res[1]][res[0]] = -1
    
    for b in range(1, n+1):
        for a in range(1, n+1):
            for c in range(1, n+1):
                if members[a][b] == 0:
                    continue
                if members[a][b] == 1 and members[b][c] == 1:
                    members[a][c] = 1
                elif members[a][b] == -1 and members[b][c] == -1:
                    members[a][c] = -1            
    answer = 0
    for m in members:
        if m.count(0) == 2:
            answer += 1
    return answer