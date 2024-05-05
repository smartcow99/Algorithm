import heapq

def solution(operations):
    
    max_heap = []
    min_heap = []
    for i, op in enumerate(operations):
        o, n = op.split()
        n = int(n)
        
        if o == 'I':
            heapq.heappush(max_heap, -n)
            heapq.heappush(min_heap, n)
        else:
            # print(i, min_heap, max_heap)
            if not max_heap:
                continue
            if n == 1:
                max_value = -heapq.heappop(max_heap)
                min_heap.remove(max_value)
            else:
                min_value = heapq.heappop(min_heap)
                max_heap.remove(-min_value)
    if not max_heap:
        return [0, 0]
    return [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
                