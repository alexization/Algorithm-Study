from itertools import combinations
import sys
input = sys.stdin.readline

l, c = map(int, input().split())
array = list(input().split())

matchList = ['a', 'e', 'i', 'o', 'u']
array.sort()
result = list(combinations(array, l))
for i in result:
    count = 0
    bCount = 0
    for m in i:
        if m in matchList:
            count += 1
        else:
            bCount += 1
    if count >= 1 and bCount >= 2:
        print(''.join(i))