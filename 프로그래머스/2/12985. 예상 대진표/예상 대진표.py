def solution(n,a,b):
    ans = 1
    # 2번 3번이면 바로 종료하네
    
    
    
    while abs((a // 2 + a % 2) - (b // 2 + b % 2)) != 0:
        a = a // 2 + a % 2
        b = b // 2 + b % 2
        ans += 1
    return ans
