import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    ans = 0
    while len(scoville) > 1:
        s = heapq.heappop(scoville)
        if s >= K:
            return ans
        ss = heapq.heappop(scoville)
        heapq.heappush(scoville, s+ss*2)
        ans += 1
    if scoville[0] >= K:
        return ans
    return -1