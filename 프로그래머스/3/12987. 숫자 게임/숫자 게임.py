import heapq

def solution(A, B):
    A = [-i for i in A]
    B = [-i for i in B]
    heapq.heapify(A)
    heapq.heapify(B)
    ans = 0
    while B and A:
        aa = heapq.heappop(A)
        bb = heapq.heappop(B)
        if -aa < -bb:
            ans += 1
        else:
            heapq.heappush(B, bb)
    return ans