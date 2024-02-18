import sys
input = sys.stdin.readline

n = int(input())
if n == 1 or n == 3:
    print(-1)
else:
    count = 0

    value, mod = divmod(n, 5)
    count += value

    if mod % 2 == 0:
        value, mod = divmod(mod, 2)
        count += value
    else:
        count -= 1
        value, mod = divmod(mod+5, 2)
        count += value

    print(count)