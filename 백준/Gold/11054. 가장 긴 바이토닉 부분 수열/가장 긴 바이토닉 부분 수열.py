import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

lis = [1] * n
for i in range(1, n):
    for j in range(0, i):
        if arr[i] > arr[j] and lis[i] < lis[j] + 1:
            lis[i] = lis[j] + 1

lds = [1] * n
for i in range(n-2, -1, -1):
    for j in range(n-1, i, -1):
        if arr[i] > arr[j] and lds[i] < lds[j] + 1:
            lds[i] = lds[j] + 1

max_length = 0
for i in range(n):
    max_length = max(max_length, lis[i] + lds[i] - 1)

print(max_length)
