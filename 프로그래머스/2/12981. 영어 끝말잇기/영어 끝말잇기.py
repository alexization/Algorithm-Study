import math
def solution(n, words):
    status = True
    data = []
    
    for i in range(len(words)):
        p = i
        count = i+1
        if len(data) == 0:
            data.append(words[i])
            continue
        if words[i] in data:
            status = False
            break
        if words[i][0] != data[-1][-1]:
            status = False
            break
        data.append(words[i])
    
    if status:
        answer = [0, 0]
    else:
        answer = [(p % n)+1, math.ceil(count / n)]
    return answer