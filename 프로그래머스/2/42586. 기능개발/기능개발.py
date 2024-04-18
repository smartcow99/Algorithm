from queue import deque

def solution(prog, sp):
    p = deque(prog)
    s = deque(sp)
    ans = []
    while p:
        cnt = 0
        
        for i in range(len(p)):
            p[i] += s[i]
        
        while p and p[0] >= 100:
            p.popleft()
            s.popleft()
            cnt += 1
        if cnt > 0:
            ans.append(cnt)
    return ans