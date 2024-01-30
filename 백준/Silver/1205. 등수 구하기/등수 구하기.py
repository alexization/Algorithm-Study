import sys

input = sys.stdin.readline

n, score, p = map(int, input().split())
data = list(map(int, input().split()))

if n == 0:
    print(1)

elif score == data[-1] and n == p:
    print(-1)

else:
    result = -1
    for i in range(n):
        if data[i] <= score:
            result = i+1
            break
    if result == -1:
        if n+1 <= p:
            print(n+1)
        else:
            print(-1)
    elif result > p:
        print(-1)
    else:
        print(result)