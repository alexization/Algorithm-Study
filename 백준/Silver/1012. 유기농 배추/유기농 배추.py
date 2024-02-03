import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

def dfs(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or ny < 0 or nx >= m or ny >= n:
            continue
        if graph[ny][nx] == 1:
            graph[ny][nx] = 0
            dfs(nx, ny)

t = int(input())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(t):
    m, n, k = map(int, input().split())
    graph = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    count = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                dfs(j, i)
                count += 1

    print(count)