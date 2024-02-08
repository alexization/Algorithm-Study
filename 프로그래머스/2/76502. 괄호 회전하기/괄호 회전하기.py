from collections import deque

def solution(s):
    answer = 0
    pair = {')':'(', ']':'[', '}':'{'}
    data = deque(s)
    for _ in range(len(s)):
        status = True
        stack = []
        for i in range(len(s)):
            if data[i] in ('(', '[', '{'):
                stack.append(data[i])
            else:  
                try:
                    value = stack.pop()
                except IndexError:
                    status = False
                    break
                    
                if value != pair[data[i]]:
                    status = False
                    break
        if len(stack) != 0:
            status = False
            
        if status == True:
            answer += 1
        data.append(data.popleft())
    return answer