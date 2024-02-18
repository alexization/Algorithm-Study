def solution(topping):
    answer = 0
    leftDic = dict()
    rightDic = dict()
    
    for t in topping:
        if t not in rightDic:
            rightDic[t] = 1
            continue
        rightDic[t] += 1

    for t in topping:
        if len(leftDic) > len(rightDic):
            break
            
        if t not in leftDic:
            leftDic[t] = 1
        
        else:
            leftDic[t] += 1
        
        if t in rightDic:
            if rightDic[t] == 1:
                del rightDic[t]
            else:
                rightDic[t] -= 1
                
        if len(leftDic) == len(rightDic):
            answer += 1
            
    return answer