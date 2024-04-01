def solution(citations):
    citations.sort(reverse=1)
    answer = 0
    for i in range(1, len(citations)+1):
        if citations[i-1] >= i:
            answer += 1    
    return answer