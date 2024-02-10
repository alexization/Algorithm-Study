from collections import deque

def solution(skill, skill_trees):
    answer = 0
    
    for tree in skill_trees:
        status = True
        t = deque(tree)
        data = deque(skill)
        while t:
            value = t.popleft()
            if value in data:
                if data[0] == value:
                    data.popleft()
                else:
                    status = False
                    break
            
        if status == True:
            answer += 1
    return answer