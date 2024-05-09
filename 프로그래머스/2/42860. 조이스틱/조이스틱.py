def solution(name):
    answer = 0
    rem = 0
    cnt = float('inf')

    for i in range(len(name)):
        if name[i] != 'A':
            answer += calc(name[i])

            if i == 0:
                continue
            tmp = rem + len(name) - i
            cnt = min(cnt, min(tmp + rem, tmp + len(name) - i))
            rem = i

    cnt = min(rem, cnt)
    return answer + cnt

def calc(c):
    cint = ord(c)
    return min(91 - cint, cint - 65)