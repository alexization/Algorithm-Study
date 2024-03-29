from collections import deque
import sys
input = sys.stdin.readline

r, c = map(int, input().split())
graph = [list(input().strip()) for _ in range(r)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

visited = [[False] * c for _ in range(r)]

def bfs(x, y):
    q = deque()
    visited[x][y] = True
    q.append((x, y))
    sheep, wolf = 0, 0
    if graph[x][y] == 'v':
        wolf += 1
    elif graph[x][y] == 'o':
        sheep += 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= r or ny >= c:
                continue
            if graph[nx][ny] == '#':
                continue
            if visited[nx][ny] == True:
                continue
            if graph[nx][ny] == 'v':
                wolf += 1
            if graph[nx][ny] == 'o':
                sheep += 1
            visited[nx][ny] = True
            q.append((nx, ny))

    return sheep, wolf

result_sheep, result_wolf = 0, 0
for i in range(r):
    for j in range(c):
        if graph[i][j] != '#' and visited[i][j] == False:
            sheep, wolf = bfs(i, j)
            if sheep > wolf:
                result_sheep += sheep
            else:
                result_wolf += wolf

print(result_sheep, result_wolf)