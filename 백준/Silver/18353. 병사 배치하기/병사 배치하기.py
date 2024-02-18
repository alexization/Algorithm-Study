import sys
input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))

newArr = []
for i in enumerate(array, start=1):
    newArr.append(i)

newArr.sort(key=lambda x : -x[1])

dp = [1] * (n+1)

for i in range(1, n):
    for j in range(i):
        if newArr[j][0] < newArr[i][0]:
            if newArr[j][1] != newArr[i][1]:
                dp[i] = max(dp[i], dp[j]+1)

answer = n - max(dp)
print(answer)