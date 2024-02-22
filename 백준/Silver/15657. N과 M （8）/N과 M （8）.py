import sys
from itertools import combinations_with_replacement
input = sys.stdin.readline

n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

array = list(combinations_with_replacement(numbers, m))
for a in array:
    for i in a:
        print(i, end=' ')
    print()