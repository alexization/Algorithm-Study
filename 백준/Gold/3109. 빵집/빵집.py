import sys
sys.setrecursionlimit(10**8)

input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(input().strip()) for _ in range(n)]

dx = [-1, 0, 1]
dy = [1, 1, 1]

def dfs(x, y):
    if y == m-1:
        return True
    for i in range(3):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue
        if visited[nx][ny] == True:
            continue
        if graph[nx][ny] == 'x':
            continue
        visited[nx][ny] = True
        if dfs(nx, ny):
            return True
    return False

result = 0
visited = [[False] * m for _ in range(n)]
for i in range(n):
    if dfs(i, 0):
        result += 1

print(result)