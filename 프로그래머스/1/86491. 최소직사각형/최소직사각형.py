import copy
def solution(sizes):
    answer = 0
    
    maxOne = -1
    maxTwo = -1
    for size in sizes:
        if size[0] < size[1]:
            size[0], size[1] = size[1], size[0]
        if size[0] > maxOne:
            maxOne = size[0]
        if size[1] > maxTwo:
            maxTwo = size[1]
    
    answer = maxOne * maxTwo
    return answer