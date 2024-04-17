from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

tomatos = deque()

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            tomatos.append((i, j))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
visited = [[False] * m for _ in range(n)]

def bfs(q):
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == False:
                    if graph[nx][ny] == 0:
                        visited[nx][ny] = True
                        graph[nx][ny] = graph[x][y] + 1
                        q.append((nx, ny))
    
bfs(tomatos)

status = False
time = -1
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            status = True
            break
        else:
            time = max(time, graph[i][j])
    
    if status:
        break

if status:
    print(-1)
else:
    print(time - 1)