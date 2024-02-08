from collections import deque

def solution(elements):
    result = set()
    data = deque(elements)
    
    for i in range(1, len(elements)+1):
        for j in range(len(elements)):
            sum_data = list(data)
            result.add(sum(sum_data[0:i]))
            data.append(data.popleft())
            
    return len(result)