import sys
input = sys.stdin.readline
INF = int(1e9)

n, s = map(int, input().split())
numList = list(map(int, input().split()))

left = 0
length = 1
minValue = INF

value = numList[0]
if value >= s:
    print(1)

else:
    for i in range(1, n):
        value += numList[i]
        length += 1

        if value >= s:
            while True:
                temp = numList[left]
                if value - temp >= s:
                    value -= temp
                    left += 1
                    length -= 1
                else:
                    minValue = min(minValue, length)
                    break

    if minValue == INF:
        print(0)
    else:
        print(minValue)