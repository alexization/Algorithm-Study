def solution(n, lost, reserve):
    answer = 0
    data = [1 for _ in range(n)]

    for r in reserve:
        data[r-1] = 2
    for l in lost:
        if data[l-1] == 2:
            data[l-1] = 1
        else:
            data[l-1] = 0
   
    for i in range(n):
        if data[i] == 0:
            if i > 0 and data[i-1] == 2:
                data[i] = 1
                data[i-1] = 1
                continue
            elif i < n-1 and data[i+1] == 2:
                data[i] = 1
                data[i+1] = 1
                continue
                
    answer = data.count(1) + data.count(2)
    return answer