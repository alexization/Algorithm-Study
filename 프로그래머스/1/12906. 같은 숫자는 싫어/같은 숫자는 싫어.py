def solution(arr):
    answer = []
    for a in arr:
        if [a] == answer[-1:]:
            continue
        answer.append(a)
    return answer