from itertools import product

def solution(word):
    answer = 0
    a = ['A', 'E', 'I', 'O', 'U']
    
    result = []
    for i in range(1, 6):
        array = list(product(a, repeat=i))
        for arr in array:
            result.append(''.join(k for k in arr))
            
    result.sort()
    answer = result.index(word) + 1
    return answer