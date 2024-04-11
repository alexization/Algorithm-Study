from collections import deque
import sys
input = sys.stdin.readline

dx = [-1, 0, 1, 0, 0, 0]
dy = [0, -1, 0, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

def bfs(z, x, y):
    q = deque()
    visited = [[[False] * m for _ in range(n)] for _ in range(h)]
    visited[z][x][y] = True
    graph[z][x][y] = 0
    q.append((z, x, y))
    while q:
        z, x, y = q.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < n and 0 <= ny < m and 0 <= nz < h:
                if graph[nz][nx][ny] == 'E':
                    return graph[z][x][y] + 1
                
                if graph[nz][nx][ny] != '#' and visited[nz][nx][ny] == False:
                    visited[nz][nx][ny] = True
                    graph[nz][nx][ny] = graph[z][x][y] + 1
                    q.append((nz, nx, ny))
    
    return -1

while True:
    h, n, m = map(int, input().split())
    if h == 0 and n == 0 and m == 0:
        break

    graph = []
    for _ in range(h):
        graph.append([list(input().strip()) for _ in range(n)])
        temp = input()
    for z in range(h):
        for x in range(n):
            for y in range(m):
                if graph[z][x][y] == 'S':
                    sz, sx, sy = z, x, y
    
    time = bfs(sz, sx, sy)
    if time == -1:
        print('Trapped!')
    else:
        print(f"Escaped in {time} minute(s).")