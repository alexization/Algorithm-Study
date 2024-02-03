from itertools import combinations_with_replacement
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

array = [i for i in range(1, n+1)]

result = list(combinations_with_replacement(array, m))

for i in result:
    for j in i:
        print(j, end=" ")
    print()