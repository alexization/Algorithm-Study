from itertools import combinations
import sys
input = sys.stdin.readline

talls = []
for _ in range(9):
    talls.append(int(input()))

comb = list(combinations(talls, 7))
result = []
for c in comb:
    if sum(c) == 100:
        result = c
        break

result = list(result)
result.sort()
for i in result:
    print(i)