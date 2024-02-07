def solution(progresses, speeds):
    answer = []
    count = 0
    while count != len(progresses):
        value = 1
        if progresses[count] >= 100:
            for i in range(count+1, len(progresses)):
                if progresses[i] < 100:
                    break
                else:
                    value += 1
            answer.append(value)
            count += value
        else:
            for i in range(count, len(progresses)):
                progresses[i] += speeds[i]
    return answer