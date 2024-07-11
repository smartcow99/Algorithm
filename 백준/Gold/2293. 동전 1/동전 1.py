import sys

input = sys.stdin.readline

n,k = map(int,input().split())
C = []
for i in range(n):      
  x = int(input())
  if(x <= k):
    C.append(x)

if(len(C)==0):
  print(0)
else:
  s = [0 for i in range(k)]
  for i in range(len(C)):
    s[C[i]-1] += 1
    for j in range(C[i],k):
      s[j] += s[j-C[i]]
  print(s[k-1])