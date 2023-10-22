def solution(n):
    bn = bin(n)
    bn = bn[2:]
    num1 = bn.count('1')
    nn = n+1
    while 1:
        tn = bin(nn)
        tn = tn[2:]
        num2 = tn.count('1')
        if num2 == num1:
            break
        nn = nn + 1
    answer = nn
    return answer