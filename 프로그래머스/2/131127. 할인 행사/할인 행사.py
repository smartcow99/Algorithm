def solution(want, number, discount):
    l = len(want)
    answer = 0
    s = 0
    while s+10 <= len(discount):
        check = True
        for i in range(l):
            nn = discount[s:s+10].count(want[i])
            if number[i] > nn:
                check = False
        if check:
            answer += 1
        s += 1
    return answer