from itertools import combinations
import sys
input = sys.stdin.readline

n = int(input())
cooks = []

for _ in range(n):
    s, b = map(int, input().split())
    cooks.append((s, b))

minDiff = int(1e9)
for i in range(1, n+1):
    sumList = list(combinations(cooks, i))
    for c in sumList:
        sSum = 1
        bSum = 0
        for item in c:
            sSum *= item[0]
            bSum += item[1]
        result = abs(sSum - bSum)
        if minDiff > result:
            minDiff = result

print(minDiff)