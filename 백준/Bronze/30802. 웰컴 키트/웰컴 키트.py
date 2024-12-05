import sys

input = sys.stdin.readline

N = int(input())
l = list(map(int, input().split()))
T, P = map(int, input().split())

ans = 0
for i in l:
    if i % T == 0:
        ans += int(i / T)
    else:
        ans += int(i / T) + 1
print(ans)
print(int(N/P), N%P)

