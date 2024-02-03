import sys
sys.setrecursionlimit(10**7)

input = sys.stdin.readline

def dfs(x, y):
    global count

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if graph[nx][ny] == 1:
            graph[nx][ny] = 0
            count += 1
            dfs(nx, ny)

n, m, k = map(int, input().split())
graph = [[0 for _ in range(m)] for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
count = 0

for _ in range(k):
    r, c = map(int, input().split())
    graph[r-1][c-1] = 1

max_count = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            count = 0
            dfs(i, j)
            max_count = max(max_count, count)

print(max_count)