def solution(clothes):
    answer = 1
    data = dict()
    
    for clothe in clothes:
        try:
            data[clothe[1]] += 1
        except KeyError:
            data[clothe[1]] = 1
    
    for i in data.values():
        answer *= (i+1)
    
    return answer-1