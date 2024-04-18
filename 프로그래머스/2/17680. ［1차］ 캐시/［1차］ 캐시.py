from collections import deque

def solution(cacheSize, cities):
    if cacheSize == 0:
        return len(cities) * 5
    ans = 0
    deq = deque([], maxlen = cacheSize)
    for city in cities:
        city = city.lower()
        if city in deq:
            deq.remove(city)
            ans += 1
        else:
            ans += 5
        deq.append(city)
    return ans
        
    
    