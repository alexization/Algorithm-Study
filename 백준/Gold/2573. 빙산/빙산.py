from collections import deque
from copy import deepcopy
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(x, y, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if temp[nx][ny] == 0:
                continue
            if visited[nx][ny] == True:
                continue
            visited[nx][ny] = True
            q.append((nx, ny))

def check():
    visited = [[False] * m for _ in range(n)]
    count = 0

    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                continue
            if visited[i][j] == False:
                count += 1
                bfs(i, j, visited)
    return count

def melt(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= m:
            continue

        if graph[nx][ny] == 0:
            temp[x][y] -= 1
            if temp[x][y] < 0:
                temp[x][y] = 0

cnt = 0
while True:
    temp = deepcopy(graph)
    for i in range(n):
            for j in range(m):
                if graph[i][j] != 0:
                    melt(i, j)

    cnt += 1
    value = check()
    if value == 0:
        print(0)
        break
    elif value > 1:
        print(cnt)
        break

    graph = deepcopy(temp)
