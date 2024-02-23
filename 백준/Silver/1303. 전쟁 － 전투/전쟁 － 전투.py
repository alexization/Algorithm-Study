from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().split())

graph = [list(input().strip()) for _ in range(m)]
new_graph = [[-1] * n for _ in range(m)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y, c):
    q = deque()
    q.append((x, y))
    new_graph[x][y] = 1
    count = 1

    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if new_graph[nx][ny] != -1 or graph[nx][ny] != c:
                continue
            
            count += 1
            new_graph[nx][ny] = new_graph[x][y]
            q.append((nx, ny))
    
    return count

w_count = 0
b_count = 0
for i in range(m):
    for j in range(n):
        if new_graph[i][j] == -1:
            if graph[i][j] == 'W':
                w_count += bfs(i, j, 'W') ** 2
            else:
                b_count += bfs(i, j, 'B') ** 2

print(w_count, b_count)