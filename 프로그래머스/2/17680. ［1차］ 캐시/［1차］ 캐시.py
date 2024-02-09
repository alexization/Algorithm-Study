from collections import deque

def solution(cacheSize, cities):
    answer = 0
    cache = deque()
    
    if cacheSize == 0:
        answer = len(cities) * 5
        return answer
    
    for i in range(len(cities)):
        data = cities[i].lower()
        if data in cache:
            answer += 1
            cache.remove(data)
            cache.append(data)
            continue
            
        if len(cache) < cacheSize:
            cache.append(data)
            answer += 5
            continue
        
        try:
            cache.popleft()
            cache.append(data)
            answer += 5
        except IndexError:
            pass
        
    return answer