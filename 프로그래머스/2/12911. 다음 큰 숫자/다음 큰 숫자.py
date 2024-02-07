def solution(n):
    value = n + 1
    count_n = list(format(n, 'b')).count('1')
    
    while True:
        bin_data = list(format(value, 'b')).count('1')
        if bin_data == count_n:
            break
        value += 1
    
    answer = value
    return answer