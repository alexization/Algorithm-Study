def solution(msg):
    answer = []
    d = dict()
    
    count = 1
    for i in range(65, 91):
        d[chr(i)] = count
        count += 1
    
    lastIdx, idx, count = 27, 0, 1
    while True:
        if idx+count == len(msg):
            if msg[idx:] in d:
                answer.append(d[msg[idx:]])                
            else:
                answer.append(d[msg[idx:idx+count-1]])
                answer.append(d[msg[-1]])
            break
        
        if msg[idx:idx+count] in d:
            count += 1
            
        else:
            answer.append(d[msg[idx:idx+count-1]])
            d[msg[idx:idx+count]] = lastIdx
            lastIdx += 1
            idx += count - 1
            count = 1
    
    return answer