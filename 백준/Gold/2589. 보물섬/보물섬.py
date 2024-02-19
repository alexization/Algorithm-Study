from collections import deque
import sys
import copy
input = sys.stdin.readline

n, m = map(int, input().split())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

graph = []
for _ in range(n):
    graph.append(list(input().strip()))

def bfs(x, y):
    newGraph = copy.deepcopy(graph)
    q = deque()
    q.append((x, y))
    newGraph[x][y] = 0
    maxVal = 0

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= n or ny >= m or nx < 0 or ny < 0:
                continue
            
            if newGraph[nx][ny] == 'L':
                newGraph[nx][ny] = newGraph[x][y] + 1
                maxVal = max(newGraph[nx][ny], maxVal)
                q.append((nx, ny))
    
    return maxVal

result = -1
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L':
            value = bfs(i, j)
            result = max(value, result)

print(result)