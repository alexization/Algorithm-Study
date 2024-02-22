import sys
from itertools import permutations

input = sys.stdin.readline
n, m = map(int, input().split())

numbers = list(map(int, input().split()))

array = list(set(permutations(numbers, m)))
array.sort()

for a in array:
    for i in a:
        print(i, end=' ')
    print()