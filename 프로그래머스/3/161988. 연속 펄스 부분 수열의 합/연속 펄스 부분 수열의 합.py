def solution(sequence):
    
    n = len(sequence)
    cache1 = [0] * n
    cache2 = [0] * n
    cache1[0] = -sequence[0]
    cache2[0] = sequence[0]
    
    for i in range(1, n):
        if i % 2 == 1:
            cache1[i] = max(0, cache1[i-1]) + sequence[i]
            cache2[i] = max(0, cache2[i-1]) - sequence[i]
        else:
            cache2[i] = max(0, cache2[i-1]) + sequence[i]
            cache1[i] = max(0, cache1[i-1]) - sequence[i]
    return max(max(cache1), max(cache2))
    