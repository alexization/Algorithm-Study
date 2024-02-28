import sys
input = sys.stdin.readline

n = int(input())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

dp = [[0] * n for _ in range(n)]
dp[0][0] = graph[0][0]

for i in range(1, n):
    for j in range(len(graph[i])):
        if j == 0:
            dp[i][j] = dp[i-1][j] + graph[i][j]
        elif j == len(graph[i]) - 1:
            dp[i][j] = dp[i-1][j-1] + graph[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + graph[i][j]
    
print(max(dp[n-1]))