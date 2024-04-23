import sys
input = sys.stdin.readline

x, n = map(int, input().split())
visitors = list(map(int, input().split()))

window = sum(visitors[:n])
maxValue = window
maxCount = 1

for i in range(n, x):
    window -= visitors[i-n]
    window += visitors[i]
    
    if window > maxValue:
        maxValue = window
        maxCount = 1
    elif window == maxValue:
        maxCount += 1

if maxValue == 0:
    print('SAD')
else:
    print(maxValue)
    print(maxCount)