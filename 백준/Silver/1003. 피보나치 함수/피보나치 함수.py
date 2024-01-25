import sys

input = sys.stdin.readline
INF = int(1e9)

t = int(input())

for _ in range(t):
    n = int(input())
    dp_zero = [0] * 41
    dp_one = [0] * 41

    dp_zero[0] = 1
    dp_one[1] = 1

    if n == 0:
        print(1, 0)
    elif n == 1:
        print(0, 1)
    else:
        for i in range(2, n+1):
            dp_zero[i] = dp_zero[i-1] + dp_zero[i-2]
            dp_one[i] = dp_one[i-1] + dp_one[i-2]
        print(dp_zero[n], dp_one[n])
