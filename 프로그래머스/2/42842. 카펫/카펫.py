def solution(brown, yellow):
    plus = brown // 2 + 2
    mul = brown + yellow
    mid = (plus + 1)//2
    for i in range(mid, plus):
        if i * (plus - i) == mul:
            return [i, plus-i]