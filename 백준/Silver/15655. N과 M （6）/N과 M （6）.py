from itertools import combinations

n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

array = list(combinations(numbers, m))

for a in array:
    for i in a:
        print(i, end=' ')
    print()