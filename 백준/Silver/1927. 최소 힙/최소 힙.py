import sys
import heapq

input = sys.stdin.readline

n = int(input())

hq = []

for i in range(n):
    num = int(input())
    if num:
        heapq.heappush(hq, num)
    else:
        if not hq:
            print(0)
        else:
            print(heapq.heappop(hq))
