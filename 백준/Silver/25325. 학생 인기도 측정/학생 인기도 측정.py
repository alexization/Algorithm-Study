import sys
input = sys.stdin.readline

n = int(input())
students = list(input().split())

sDict = dict()
for student in students:
    sDict[student] = 0

for _ in range(n):
    valueList = list(input().split())
    for value in valueList:
        sDict[value] += 1

result = []
for item, value in sDict.items():
    result.append((item, value))
result.sort(key=lambda x: (-x[1], x[0]))
for i in result:
    print(i[0], i[1])