from itertools import combinations
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

array = [i for i in range(1, n+1)]

result = list(combinations(array, m))

for i in result:
    for j in i:
        print(j, end=" ")
    print()