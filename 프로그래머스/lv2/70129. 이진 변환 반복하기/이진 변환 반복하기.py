answer = [0, 0]
def dfs(s):
    if s == '1':
        return 0
    answer[0] += 1
    n = s.count('0')
    answer[1] += n
    return len(s) - n

def solution(s):
    while True:
        n = dfs(s)
        if n == 0:
            break
        s = bin(n)
        s = s[2:]
    return answer