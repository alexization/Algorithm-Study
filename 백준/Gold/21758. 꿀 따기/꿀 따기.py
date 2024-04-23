import sys
input = sys.stdin.readline

n = int(input())
honeys = [0] + list(map(int, input().split()))

value = 0
arr = []
for honey in honeys:
    value += honey
    arr.append(value)

def cal(i, j, k):
    sumLeft1 = arr[j-1] - arr[i-1]
    sumLeft2 = arr[k-1] - arr[i-1] - honeys[j]
    result1 = sumLeft1 + sumLeft2

    sumMid1 = arr[j] - arr[i]
    sumMid2 = arr[k-1] - arr[j-1]
    result2 = sumMid1 + sumMid2

    sumRight1 = arr[k] - arr[i] - honeys[j]
    sumRight2 = arr[k] - arr[j]
    result3 = sumRight1 + sumRight2

    return max(result1, result2, result3)

result = 0
for i in range(2, n):
    result = max(result, cal(1, i, n))

print(result)