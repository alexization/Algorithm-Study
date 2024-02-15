def solution(sequence, k):
    answer = []
    intervalSum = 0
    end = 0
    
    minNum = int(1e9)
    for start in range(len(sequence)):
        while intervalSum < k and end < len(sequence):
            intervalSum += sequence[end]
            end += 1
        
        if intervalSum == k:
            if minNum > (end - start):
                minNum = end - start
                answer = []
                answer.append(start)
                answer.append(end-1)
        
        intervalSum -= sequence[start]
        
    return answer