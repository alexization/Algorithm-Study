import copy

def solution(number, k):
    answer = ''
    newStr = number[:k*2]
    leftStr = number[k*2:]
    
    newList = list(newStr)
    result = copy.deepcopy(newList)
    newList.sort()
    delList = newList[:k]
    
    for i in delList:
        result.remove(i)
        
    answer = ''.join(result) + leftStr
    return answer