from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0, -1, 1, -1, 1]
dy = [0, -1, 0, 1, 1, 1, -1, -1]

def bfs(x, y, visited):
    q = deque()
    visited[x][y] = True
    q.append((x, y))
    while q:
        x, y = q.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if visited[nx][ny] == True:
                continue
            if graph[nx][ny] == 0:
                continue
            visited[nx][ny] = True
            q.append((nx, ny))


while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(m)]
    visited = [[False] * n for _ in range(m)]

    count = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1 and visited[i][j] == False:
                bfs(i, j, visited)
                count += 1
    
    print(count)