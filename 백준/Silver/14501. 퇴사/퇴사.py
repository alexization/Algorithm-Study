import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n+1)
array = []

for i in range(n):
    day, money = map(int, input().split())
    array.append([day, money])

for i in range(n):
    for j in range(i+array[i][0], n+1):
        if dp[j] < dp[i] + array[i][1]:
            dp[j] = dp[i] + array[i][1]

print(dp[-1])