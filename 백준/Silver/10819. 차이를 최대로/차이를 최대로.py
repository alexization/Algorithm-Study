from itertools import permutations
import sys
input = sys.stdin.readline

n = int(input())
numList = list(map(int, input().split()))

sumList = list(permutations(numList, n))

maxValue = -1
tempList = []
for item in sumList:
    value = 0
    for i in range(1, len(item)):
        value += abs(item[i-1] - item[i])
    if maxValue < value:
        tempList = item
        maxValue = value

print(maxValue)