import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arrDict = dict()
for _ in range(n):
    arrDict[input().strip()] = 0

for _ in range(m):
    value = input().strip()
    if value in arrDict:
        arrDict[value] += 1
    
count = 0
for value in arrDict.values():
    count += value

print(count)