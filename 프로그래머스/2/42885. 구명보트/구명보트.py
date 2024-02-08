from collections import deque

def solution(people, limit):
    answer = 0
    people.sort(reverse=True)
    data = deque(people)
    
    while data:
        
        if data[0] + data[-1] <= limit and len(data) != 1:
            answer += 1
            data.popleft()
            data.pop()
            continue
            
        data.popleft()
        answer += 1
        
    return answer