from collections import deque
def solution(s):
    answer = -1
    data = deque(s)
    data.append(-1)
    data.append(data.popleft())

    while True:
        if data[0] == -1:
            break

        if data[0] == data[-1]:
            data.pop()
            data.popleft()
        else:
            data.append(data.popleft())
    
    if len(data) == 1:
        answer = 1
    else:
        answer = 0

    return answer