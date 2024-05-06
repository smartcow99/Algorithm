import heapq

def solution(numbers):
    n = len(numbers)
    answer = [-1 for i in range(n)]
    heap = []
    
    for i in range(n):
        v = numbers[i]
        
        while heap and heap[0][0] < v:
            _, idx = heapq.heappop(heap)
            answer[idx] = v
        
        heapq.heappush(heap, [v, i])
        
    return answer