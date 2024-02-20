from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
x1, y1, x2, y2 = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

graph = [list(input().strip()) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]

q = deque()
q.append((x1-1, y1-1))
visited[x1-1][y1-1] = 0

while q:
    x, y = q.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= n or ny >= m or nx < 0 or ny < 0:
            continue

        if visited[nx][ny] == -1:
            if graph[nx][ny] == '0':
                visited[nx][ny] = visited[x][y]
                q.appendleft((nx, ny))
            
            elif graph[nx][ny] == '1' or graph[nx][ny] == '#':
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

print(visited[x2-1][y2-1])