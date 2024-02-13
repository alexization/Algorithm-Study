def solution(numbers):
    answer = [0 for _ in range(len(numbers))]
    stack = []
    
    for i in range(len(numbers)):
        while stack:
            if numbers[stack[-1]] < numbers[i]:
                idx = stack.pop()
                answer[idx] = numbers[i]
            else:
                break
        
        stack.append(i)

    while stack:
        idx = stack.pop()
        answer[idx] = -1

    return answer