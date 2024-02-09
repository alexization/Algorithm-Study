def solution(prices):
    answer = [0 for _ in range(len(prices))] 
    len_price = len(prices)
    stack = []
    
    stack.append([prices[0], 1])
    for i in range(1, len_price):
        while True:
            if len(stack) == 0:
                break
            if prices[i] < stack[-1][0]:
                price, time = stack.pop()
                answer[time-1] = i - time + 1
            else:
                break
                
        stack.append([prices[i], i+1])
        
    while len(stack) != 0:
        price, time = stack.pop()
        answer[time-1] = len_price - time
    
    return answer