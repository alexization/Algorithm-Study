def solution(citations):
    citations.sort(reverse=True)
    
    for num, val in enumerate(citations):
        if num >= val:
            return num
    return len(citations)