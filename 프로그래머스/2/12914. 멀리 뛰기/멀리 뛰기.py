def solution(n):
    l = [0 for _ in range(2001)]
    l[1] = 1
    l[2] = 2
    for i in range(3, n+1):
        l[i] = (l[i-1] + l[i-2])%1234567
    return l[n]