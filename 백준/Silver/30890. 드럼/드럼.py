import sys

input = sys.stdin.readline

x, y = map(int, input().strip().split())
ans = []

for i in range(1, x*y+1):
    if i % x == 0 and i % y == 0:
        ans.append(3)
    elif i % x == 0:
        ans.append(2)
    elif i % y == 0:
        ans.append(1)
for i in ans:
    print(i, end="")