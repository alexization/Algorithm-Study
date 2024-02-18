import sys
input = sys.stdin.readline

board = list(input().strip())
stack = []
result = []

count = 0
for i in board:
    if i == 'X':
        stack.append(i)
        count += 1
    else:
        stack.clear()
        if count == 0:
            result.append('.')
            continue

        value, mod = divmod(count, 4)
        result.append('AAAA' * value)
        value, mod = divmod(mod, 2)
        result.append('BB' * value)
        result.append('.')
        
        count = 0
        if mod > 0 :
            result.append(-1)
            break

if stack:
    value, mod = divmod(count, 4)
    result.append('AAAA' * value)
    value, mod = divmod(mod, 2)
    result.append('BB' * value)
        
    if mod > 0 :
        result.append(-1)
if result[-1] == -1:
    print(-1)
else:
    print(''.join(result))