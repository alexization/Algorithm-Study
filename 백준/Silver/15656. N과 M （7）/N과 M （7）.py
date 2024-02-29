from itertools import product
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = list(map(int, input().split()))

array.sort()
p_array = list(product(array, repeat=m))

for p in p_array:
    for i in p:
        print(i, end=' ')
    print()