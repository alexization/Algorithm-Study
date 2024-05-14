T = 10

for test_case in range(1, T+1):
    n = int(input())
    arr = list(input())

    leftArr = ['(', '[', '{', '<']
    correct = {')' : '(', ']' : '[', '}' : '{', '>' : '<'}
    stack = []
    status = False
    for value in arr:
        if value in leftArr:
            stack.append(value)
        else:
            if stack[-1] == correct[value]:
                stack.pop()
            else:
                status = True
                break
    
    if status:
        print(f"#{test_case} 0")
    else:
        print(f"#{test_case} 1")