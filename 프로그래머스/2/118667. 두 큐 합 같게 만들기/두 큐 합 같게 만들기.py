from collections import deque
def solution(queue1, queue2):
    answer = 0
    sumA = sum(queue1)
    sumB = sum(queue2)
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    
    while sumA != sumB:
        if len(queue1) == 0 or len(queue2) == 0 or answer > (len(queue1) + len(queue2) + 10):
            answer = -1
            break
            
        if sumA > sumB:
            value = queue1.popleft()
            sumA -= value
            sumB += value
            queue2.append(value)
        else:
            value = queue2.popleft()
            sumA += value
            sumB -= value
            queue1.append(value)
        answer += 1
    return answer