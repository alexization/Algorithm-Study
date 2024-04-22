import sys
from itertools import combinations
input = sys.stdin.readline

n, m = map(int, input().split())
cards = list(map(int, input().split()))

combList = list(combinations(cards, 3))
maxValue = -1
for a, b, c in combList:
    value = a + b + c
    if value <= m:
        maxValue = max(maxValue, value)

print(maxValue)