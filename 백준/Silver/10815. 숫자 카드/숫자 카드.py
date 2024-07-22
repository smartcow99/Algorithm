import sys
input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().split()))
m = int(input())
check = list(map(int, input().split()))

arr = [0 for _ in range(-10000000, 10000001)]
for card in cards:
    arr[card] = 1
for c in check:
    print(arr[c], end=' ')