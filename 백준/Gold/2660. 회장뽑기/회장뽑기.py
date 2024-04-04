import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
graph = [[INF] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            graph[i][j] = 0

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    graph[a][b] = 1
    graph[b][a] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] == 1:
                continue
            elif graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

maxScore = INF
members = []

for i in range (1, n+1):
    score = 0
    for j in graph[i][1:]:
        if score < j:
            score = j
    if maxScore > score:
        maxScore = score
        members.clear()
        members.append(i)
    elif maxScore == score:
        members.append(i)

print(maxScore, len(members))
members.sort()
print(*members)