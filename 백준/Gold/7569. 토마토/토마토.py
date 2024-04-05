import sys
from collections import deque
input = sys.stdin.readline

m, n, h = map(int, input().split())
boxs = [[] for _ in range(h)]

for i in range(h):
    for _ in range(n):
        boxs[i].append(list(map(int, input().split())))

zeroCount = 0
q = deque()
for z in range(h):
    for i in range(n):
        for j in range(m):
            if boxs[z][i][j] == 0:
                zeroCount += 1
            elif boxs[z][i][j] == 1:
                q.append((i, j, z))

dx = [-1, 0, 1, 0, 0, 0]
dy = [0, -1, 0, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

def bfs(zeroCount):
    while q:
        x, y, z = q.popleft()
        visited[z][x][y] = True
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]
            nz = z + dz[i]
            if 0 <= nx < n and 0 <= ny < m and 0 <= nz < h:
                if boxs[nz][nx][ny] == 0 and visited[nz][nx][ny] == False:
                    zeroCount -= 1
                    boxs[nz][nx][ny] = boxs[z][x][y] + 1
                    visited[nz][nx][ny] = True
                    q.append((nx, ny, nz))
    return zeroCount

visited = [[[False] * m for _ in range(n)] for _ in range(h)]
value = bfs(zeroCount)
if value > 0:
    print(-1)
else:
    maxValue = -1
    for b in boxs:
        for i in b:
            for k in i:
                maxValue = max(maxValue, k)
    print(maxValue - 1)