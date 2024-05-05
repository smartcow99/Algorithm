import heapq

def solution(n, works):
    if n >= sum(works):
        return 0
    
    works = [-work for work in works]
    heapq.heapify(works)
    
    for i in range(n):
        max_work = heapq.heappop(works)
        max_work += 1
        heapq.heappush(works, max_work)
    
    answer = sum(work ** 2 for work in works)
    return answer
