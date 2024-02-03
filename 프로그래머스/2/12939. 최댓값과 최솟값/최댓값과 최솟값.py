def solution(s):
    array = list(map(int, s.split(" ")))
    array.sort()
    answer = f'{array[0]} {array[-1]}'
    return answer