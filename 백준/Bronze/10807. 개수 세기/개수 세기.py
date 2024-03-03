from collections import Counter
n = int(input())
array = list(map(int, input().split()))
find = int(input())
print(Counter(array)[find])