array = list(input())

stack = []
value_stack = []

result = 1
answer = 0
for i in range(len(array)):
    status = True
    if array[i] == '(':
        result *= 2
        stack.append(array[i])

    elif array[i] == '[':
        result *= 3
        stack.append(array[i])

    elif array[i] == ')':
        if len(stack) == 0:
            status = False
            break

        value = stack.pop()
        if value == '[':
            status = False
            break
        else:
            if value == array[i-1]:
                answer += result
        result //= 2
        
    else:
        if len(stack) == 0:
            status = False
            break

        value = stack.pop()
        if value == '(':
            status = False
            break
        else:
            if value == array[i-1]:
                answer += result
        result //=3

if status == False or len(stack) != 0:
    print(0)
else:
    print(answer)