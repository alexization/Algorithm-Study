import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    array = list(map(int, input().split()))

    stack = []
    sum = 0
    maxValue = array[-1]
    for i in range(n-2, -1, -1):
        if maxValue > array[i]:
            stack.append(array[i])
        elif maxValue < array[i]:
            while stack:
                value = stack.pop()
                sum += maxValue - value
            maxValue = array[i]
    
    while stack:
        value = stack.pop()
        sum += maxValue - value
    print(sum)