def solution(nums):
    answer = 0
    
    count = len(nums) / 2
    numSet = set(nums)
    lenSet = len(numSet)
    
    if count <= lenSet:
        answer = count
    else:
        answer = lenSet
    
    return answer