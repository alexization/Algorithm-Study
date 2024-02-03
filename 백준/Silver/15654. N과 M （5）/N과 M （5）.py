from itertools import permutations
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

array = list(map(int, input().split()))
array.sort()

result = list(permutations(array, m))

for i in result:
    for j in i:
        print(j, end=" ")
    print()