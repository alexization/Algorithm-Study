import sys
sys.setrecursionlimit(10**7)

input = sys.stdin.readline

def dfs(x, y):
    global area
    graph[x][y] = 1
    area += 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue
        if graph[nx][ny] == 0:
            dfs(nx, ny)

m, n, k = map(int, input().split())
graph = [[0 for _ in range(n)] for _ in range(m)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1

count = 0
result = []
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            area = 0
            count += 1
            dfs(i, j)
            result.append(area)

result.sort()
print(count)
print(*result)