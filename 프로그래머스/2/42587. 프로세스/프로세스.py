from collections import deque
def solution(priorities, location):
    answer = 0
    data = deque()
    for i in range(len(priorities)):
        data.append([priorities[i], i])
        
    while True:
        p, l = data.popleft()
        status = False
        for i in data:
            if p < i[0]:
                status = True
                break
        if status == True:
            data.append([p, l])
            continue
            
        answer += 1
        if location == l:
            break
        
    return answer