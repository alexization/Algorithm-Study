def solution(s):
    answer = []
    array = ''.join(s.split("{"))
    array = ''.join(array.split("}"))
    array = array.split(",")
    
    strDict = dict()
    strSet = set(array)
    for s in strSet:
        strDict[s] = 0
    for a in array:
        strDict[a] += 1
    result = []
    for value, count in strDict.items():
        result.append([value, count])
    result.sort(key=lambda x : -x[1])

    for r in result:
        answer.append(int(r[0]))
    return answer