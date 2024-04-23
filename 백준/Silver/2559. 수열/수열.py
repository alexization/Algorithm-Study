import sys
input = sys.stdin.readline

n, k = map(int, input().split())
temps = list(map(int, input().split()))

tempArr = []
value = 0
for temp in temps:
    value += temp
    tempArr.append(value)

maxValue = tempArr[k-1]
for i in range(n-k):
    maxValue = max(maxValue, (tempArr[i+k] - tempArr[i]))

print(maxValue)