import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))

dp = [1] * (n+1)

for i in range(n):
    dp[i] = array[i]

for i in range(1, n):
    for j in range(i):
        if array[j] < array[i]:
            dp[i] = max(dp[i], dp[j] + array[i])

print(max(dp))