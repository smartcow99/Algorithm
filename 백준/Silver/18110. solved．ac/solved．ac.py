import sys
import math

input = sys.stdin.readline
n = int(input())

def mround(num):
    return math.floor(num + 0.5)

if n == 0:
    print(0)
else:
    diff = [int(input().strip()) for _ in range(n)]
    diff.sort()

    cut = mround(n * 0.15)
    res = diff[cut:n - cut]

    avg = sum(res) / len(res)
    print(mround(avg))
