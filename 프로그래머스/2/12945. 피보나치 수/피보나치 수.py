f = [0, 1]
def solution(n):
    if n == 2:
        return f[1]
    for i in range(2,n):
        f.append(f[i-2] + f[i-1])
    return (f[n-2]+f[n-1])%1234567
