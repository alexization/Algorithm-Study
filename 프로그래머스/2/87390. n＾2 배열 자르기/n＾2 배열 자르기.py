def solution(n, left, right):
    left_count = left // n + 1
    right_count = right // n + 1
    
    temp = []
    
    for i in range(left_count, right_count + 1):
        for _ in range(i):
            temp.append(i)
        for j in range(i, n):
            temp.append(j+1)
            
    slic = left%n
    return temp[slic:slic+(right-left)+1]