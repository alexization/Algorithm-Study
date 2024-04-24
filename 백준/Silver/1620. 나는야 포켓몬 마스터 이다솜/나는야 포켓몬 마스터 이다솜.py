import sys
input = sys.stdin.readline

n, m = map(int, input().split())
poketDict = dict()

for i in range(1, n+1):
    value = input().strip()
    poketDict[value] = i

valueDict = dict()
for key, value in poketDict.items():
    valueDict[value] = key

for _ in range(m):
    value = input().strip()
    if 49 <= ord(value[0]) <= 57:
        print(valueDict[int(value)])
    else:
        print(poketDict[value])