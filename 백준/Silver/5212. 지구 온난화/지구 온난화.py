import sys
from collections import deque
from copy import deepcopy
input = sys.stdin.readline

r, c = map(int, input().split())

graph = []
for _ in range(r):
    graph.append(list(input().strip()))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
new_graph = deepcopy(graph)
visited = [[False] * c for _ in range(r)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        count = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= r or ny >= c:
                count += 1
                continue
            if graph[nx][ny] == '.':
                count += 1
            if graph[nx][ny] == 'X' and visited[nx][ny] == False:
                q.append((nx, ny))
        if count >= 3:
            new_graph[x][y] = '.'


for i in range(r):
    for j in range(c):
        if graph[i][j] == 'X' and visited[i][j] == False:
            bfs(i, j)

x1, y1, x2, y2 = r-1, c-1, 0, 0
for i in range(r):
    for j in range(c):
        if new_graph[i][j] == 'X':
            if x2 < i:
                x2 = i
            if y2 < j:
                y2 = j
            if x1 > i:
                x1 = i
            if y1 > j:
                y1 = j

for i in range(x1, x2+1):
    for j in range(y1, y2+1):
        print(new_graph[i][j], end='')
    print()