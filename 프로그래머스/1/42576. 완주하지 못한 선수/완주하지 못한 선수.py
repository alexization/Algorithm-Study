def solution(participant, completion):
    answer = ''
    partDict = dict()
    for p in participant:
        if p not in partDict:
            partDict[p] = 1
            continue
        partDict[p] += 1
    
    for c in completion:
        partDict[c] -= 1
    
    for name, value in partDict.items():
        if value > 0:
            answer = name
        
    return answer