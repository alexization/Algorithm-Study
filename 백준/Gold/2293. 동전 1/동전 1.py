from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
coins = []
dp = [0] * (k+1)
for _ in range(n):
    value = int(input())
    coins.append(value)

dp[0] = 1

for i in coins:
    for j in range(i, k+1):
        if j-i >= 0:
            dp[j] += dp[j-i]

print(dp[k])