def solution(answers):
    student = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    
    temp = [0, 0, 0]
    for idx, answer in enumerate(answers):
        for i in range(3):
            if student[i][idx%len(student[i])] == answer:
                temp[i] += 1
    
    maxScore = max(temp)
    result = []
    for i in range (3):
        if temp[i] == maxScore:
            result.append(i+1)
    return result