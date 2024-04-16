def solution(k, dungeons):
    
    answer = -1
    def dfs(c, k, dun):
        nonlocal answer
        
        for i, d in enumerate(dun):
            if k >= d[0]:
                nd = dun.copy()
                nd.pop(i)
                mx = dfs(c + 1, k - d[1], nd)
            
                answer = max(answer, mx)
        return c
    
    dfs(0 ,k, dungeons)
    
    return answer