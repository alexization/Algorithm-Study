import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 0, 1, 0, -1, -1, 1, 1]
dy = [0, -1, 0, 1, -1, 1, -1, 1]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    while q:
        x, y = q.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n:
                if graph[nx][ny] == 1 and visited[nx][ny] == False:
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
                count += 1
                bfs(i, j)
    
    print(count)