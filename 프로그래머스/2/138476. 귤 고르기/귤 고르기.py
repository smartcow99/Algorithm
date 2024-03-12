def solution(k, tangerine):
    size = [0 for _ in range(max(tangerine) + 1)]
    for i in tangerine:
        size[i] += 1
    size = [i for i in size if i > 0]
    size.sort(reverse = True)
    sum = 0
    for i in range(len(size)):
        sum += size[i]
        if sum >= k:
            return i+1
        
    