from itertools import combinations
from collections import deque
import sys
INF = int(1e9)
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(q, graph, zero):
    maxValue = 0
    for i in q:
        x, y = i[0], i[1]
        graph[x][y] = 0
        visited[x][y] = True

    while q:
        x, y = q.popleft()
        if zero == 0:
            break
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] == 0 or graph[nx][ny] == '*':
                    if visited[nx][ny] == False:
                        if graph[nx][ny] == 0:
                            zero -= 1
                        graph[nx][ny] = graph[x][y] + 1
                        maxValue = max(maxValue, graph[nx][ny])
                        q.append((nx, ny))

    if zero > 0:
        return INF
    return maxValue

virus = []
zero_count = 0
for i in range(n):
    for j in range(n):
        if graph[i][j] == 2:
            virus.append((i, j))
            graph[i][j] = '*'
        elif graph[i][j] == 0:
            zero_count += 1

combVirus = deque(combinations(virus, m))

minValue = INF
for v in combVirus:
    v = deque(v)
    temp = [i[:] for i in graph]
    visited = [[False] * n for _ in range(n)]
    minValue = min(minValue, bfs(v, temp, zero_count))

if minValue == INF:
    print(-1)
else:
    print(minValue)