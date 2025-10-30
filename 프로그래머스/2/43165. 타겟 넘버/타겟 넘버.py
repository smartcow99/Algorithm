def solution(numbers, target):
    answer = 0
    n = len(numbers)
    def dfs(idx, num):
        
        nonlocal answer
        
        if idx == n - 1:
            if target == num + numbers[idx] or target == num - numbers[idx]:
                answer += 1
            return
        dfs(idx + 1, num + numbers[idx])
        dfs(idx + 1, num - numbers[idx])
    dfs(0, 0)
    return answer