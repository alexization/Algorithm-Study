def solution(s):
    answer = []
    temp = list(s)
    count = 0
    zero_count = 0
    while True:
        if len(temp) == 1 and temp[0] == '1':
            break
        data = format(temp.count('1'), 'b')
        zero_count += temp.count('0')
        count += 1
        temp = data
    answer = [count, zero_count]
    return answer