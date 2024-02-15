from math import sqrt

def solution(n, k):
    answer = 0
    value = n
    
    reverseStr = ''
    while value:
        reverseStr += str(value % k)
        value //= k
    
    resultStr = reverseStr[::-1]
    array = resultStr.split('0')
    
    for a in array:
        if a == '1' or a == '':
            continue
        value = int(a)
        status = True
        for i in range(2, int(sqrt(value))+1):
            if value % i == 0:
                status = False
                break
        if status == True:
            answer += 1
    
    return answer