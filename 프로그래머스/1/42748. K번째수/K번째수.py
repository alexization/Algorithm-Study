def solution(array, commands):
    answer = []
    for x in commands:
        i, j, k = x[0], x[1], x[2]
        new_array = array[i-1:j]
        new_array.sort()
        answer.append(new_array[k-1])
    return answer