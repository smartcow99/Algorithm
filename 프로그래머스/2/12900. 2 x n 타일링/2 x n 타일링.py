def solution(n):
    answer = [0 for _ in range(n + 2)]
    answer[1] = 1
    answer[2] = 2
    for i in range(2, n+1):
        answer[i + 1] = (answer[i] + answer[i-1]) % 1000000007
    return answer[n]