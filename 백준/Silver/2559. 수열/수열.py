import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))
result = sum(arr[:k])

temp = result
for i in range(k, n):
    temp += arr[i] - arr[i-k]
    result = max(result, temp)

print(result)