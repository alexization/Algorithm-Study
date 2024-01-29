import sys

input = sys.stdin.readline
m = int(input().strip())
data = set()

for i in range(m):

    input_data = input().strip()

    if input_data == 'all':
        c = 'all'
    elif input_data == 'empty':
        c = 'empty'
    else:
        c, val = input_data.split(' ')

    if c == 'add':
        data.add(val)

    elif c == 'remove':
        data.discard(val)

    elif c == 'check':
        if val in data:
            print("1")
        else:
            print("0")

    elif c == 'toggle':
        if val in data:
            data.discard(val)
        else:
            data.add(val)

    elif c == 'all':
        data = set(str(i) for i in range(1, 21))
    elif c == 'empty':
        data = set()