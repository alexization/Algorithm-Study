def solution(number, k):
    answer = ''
    stack = []
    
    for n in number:
        while True:
            if k <= 0:
                break
            if stack and stack[-1] < n :
                stack.pop()
                k -= 1
            else:
                break
                
        stack.append(n)
        
    while k > 0:
        stack.pop()
        k -= 1
        
    return ''.join(stack)