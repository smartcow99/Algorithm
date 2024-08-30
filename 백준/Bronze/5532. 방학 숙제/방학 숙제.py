import sys

input = sys.stdin.readline

L = int(input())
A = int(input())
B = int(input())
C = int(input())
D = int(input())

korean = A // C
if A % C != 0:
    korean += 1
math = B // D
if B % D != 0:
    math += 1
day = max(korean, math)
free_day = L - day
print(free_day)
