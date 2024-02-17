def solution(str1, str2):
    answer = 0
    str1 = str1.lower()
    str2 = str2.lower()
    dic1 = dict()
    dic2 = dict()
    
    for i in range(0, len(str1)-1):
        if 97 <= ord(str1[i]) <= 122 and 97 <= ord(str1[i+1]) <= 122:
            if str1[i:i+2] not in dic1:
                dic1[str1[i:i+2]] = 1
                continue
            dic1[str1[i:i+2]] += 1
            
    for i in range(0, len(str2)-1):
        if 97 <= ord(str2[i]) <= 122 and 97 <= ord(str2[i+1]) <= 122:
            if str2[i:i+2] not in dic2:
                dic2[str2[i:i+2]] = 1
                continue
            dic2[str2[i:i+2]] += 1
    countA = 0
    countB = 0
    for item, value in dic1.items():
        if item in dic2:
            num = min(value, dic2[item])
            dic2[item] = abs(value - dic2[item])
            countA += num
            countB += num
        else:
            countB += value
    
    for value in dic2.values():
        countB += value
    
    try:
        answer = int((countA / countB) * 65536)
    except ZeroDivisionError:
        answer = 65536
    return answer