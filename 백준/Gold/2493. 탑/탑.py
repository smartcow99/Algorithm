import sys

input = sys.stdin.readline

n = int(input())
tower = list(map(int, input().split()))

stk = []
ans = []
for i, t in enumerate(tower):
    while stk and tower[stk[-1]] < t:
        stk.pop()
    if not stk:
        ans.append(0)
    else:
        ans.append(stk[-1] + 1)
    stk.append(i)

for i in ans:
    print(i, end = ' ')