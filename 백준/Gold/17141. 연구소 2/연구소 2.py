import sys
from collections import deque
from itertools import combinations
input = sys.stdin.readline
INF = int(1e9)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def virus(x, y, temp, visited):
    q = deque()
    q.append((x, y))
    temp[x][y] = 0
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if graph[nx][ny] == '-':
                continue
            if visited[nx][ny] == True:
                continue
            if graph[nx][ny] == 0 or graph[nx][ny] == 2:
                temp[nx][ny] = min(temp[nx][ny], temp[x][y] + 1)
                visited[nx][ny] = True
                q.append((nx, ny))

def count_time(temp):
    time = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] != '-' and temp[i][j] == INF:
                return INF
            if temp[i][j] == INF:
                continue
            time = max(time, temp[i][j])
    
    return time

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
virus_pos = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            graph[i][j] = '-'
        if graph[i][j] == 2:
            virus_pos.append([i, j])

virus_array = list(combinations(virus_pos, m))
result = []
time = int(1e9)
for array in virus_array:
    temp = [[INF] * n for _ in range(n)]
    for pos in array:
        x, y = pos[0], pos[1]
        visited = [[False] * n for _ in range(n)]
        virus(x, y, temp, visited)

    result.append(count_time(temp))

if min(result) == INF:
    print(-1)
else:
    print(min(result))