def solution(n, s):
    answer = []
    
    value, mod = divmod(s, n)
    
    if value == 0:
        answer.append(-1)
        return answer
    
    if mod == 0:
        for i in range(n):
            answer.append(value)
    else:
        for i in range(n-mod):
            answer.append(value)
        for i in range(mod):
            answer.append(value+1)

    return answer