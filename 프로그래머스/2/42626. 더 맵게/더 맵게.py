from heapq import heappush, heappop, heapify

def solution(scoville, K):
    heapify(scoville)
    ans = 0
    while scoville[0] < K:
        if len(scoville) == 1:
            return -1
        ans += 1
        first = heappop(scoville)
        second = heappop(scoville) * 2
        heappush(scoville, first + second)
    return ans