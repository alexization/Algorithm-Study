from itertools import permutations
def solution(numbers):
    answer = 0
    numList = list(numbers)
    perList = []
    for i in range(1, len(numbers)+1):
        perList.extend(list(permutations(numList, i)))
    
    perSet = set()
    for per in perList:
        perSet.add(int(''.join(per)))
    per = list(perSet)
    
    for p in per:
        if p == 0:
            continue
        if p == 1:
            continue
        
        status = False
        for i in range(2, p):
            if p % i == 0:
                status = True
                break
        if status == False:
            answer += 1
            
    return answer