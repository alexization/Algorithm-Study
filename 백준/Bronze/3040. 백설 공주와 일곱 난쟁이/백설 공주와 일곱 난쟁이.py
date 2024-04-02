from itertools import combinations
import sys
input = sys.stdin.readline

people = []
for _ in range(9):
    people.append(int(input()))

tempList = list(combinations(people, 7))
result = []
for i in tempList:
    if sum(i) == 100:
        result = i
        break

for r in result:
    print(r)