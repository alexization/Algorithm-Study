from itertools import combinations
import sys
input = sys.stdin.readline

while True:
    array = list(map(int, input().split()))
    if array[0] == 0:
        break

    result = list(combinations(array[1:], 6))
    for i in result:
        print(*i)
    print()