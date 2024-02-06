def solution(arr):
    answer = []
    val = arr[0]
    answer.append(arr[0])
    for i in range(1, len(arr)):
        if arr[i] != arr[i-1]:
            val = arr[i]
            answer.append(arr[i])
    return answer