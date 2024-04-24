import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
temp = [i for i in arr]

temp.sort()
tempDict = dict()
count = 0
for i in temp:
    if i not in tempDict:
        tempDict[i] = count
        count += 1

for i in arr:
    print(tempDict[i], end=' ')