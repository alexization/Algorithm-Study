import sys
from collections import deque
input = sys.stdin.readline

n, x = map(int, input().split())
visitors = deque(map(int, input().split()))
tempQ = deque()

maxVisitors = 0
maxDays = 1
for _ in range(x):
    value = visitors.popleft()
    tempQ.append(value)
    maxVisitors += value

dayVisitors = maxVisitors
for value in visitors:
    minusValue = tempQ.popleft()
    dayVisitors -= minusValue
    tempQ.append(value)
    dayVisitors += value
    
    if dayVisitors > maxVisitors:
        maxVisitors = dayVisitors
        maxDays = 1
    elif dayVisitors == maxVisitors:
        maxDays += 1

if maxVisitors == 0:
    print('SAD')
else:
    print(maxVisitors)
    print(maxDays)