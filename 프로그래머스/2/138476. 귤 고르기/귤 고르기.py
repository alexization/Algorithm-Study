def solution(k, tangerine):
    answer = 0
    dic_tan = {}
    set_tan = set(tangerine)
    for s in set_tan:
        dic_tan[s] = 0
    for i in range(len(tangerine)):
        dic_tan[tangerine[i]] += 1
    
    data = []
    for val in dic_tan.values():
        data.append(val)
    data.sort(reverse=True)
    
    sum = 0
    for i in data:
        answer += 1
        sum += i
        if sum >= k:
            break
    return answer