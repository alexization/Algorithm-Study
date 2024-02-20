import sys
input = sys.stdin.readline

n = int(input())
length = 10*n

dp = [0] * length

for i in range(10):
    dp[i] = i + 1

if n > 1:
    for i in range(10, length):
        if i % 10 == 0:
            dp[i] = 1
            continue
        dp[i] = (dp[i-1] + dp[i-10]) % 10007

print(dp[length-1])