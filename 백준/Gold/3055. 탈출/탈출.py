from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(input().strip()) for _ in range(n)]

water = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'S':
            x, y = i, j
        elif graph[i][j] == '*':
            water.append((i, j))

visited = [[False] * m for _ in range(n)]
water_visited = [[False] * m for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):
    q = deque()
    q.append((x, y, 1))
    visited[x][y] = True

    while True:
        for _ in range(len(water)):
            wx, wy = water.popleft()

            for i in range(4):
                nx = wx + dx[i]
                ny = wy + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                if graph[nx][ny] == 'X' or graph[nx][ny] == 'D':
                    continue
                if water_visited[nx][ny] == True:
                    continue
                water_visited[nx][ny] = True
                graph[nx][ny] = '*'
                water.append((nx, ny))

        for _ in range(len(q)):
            x, y, count = q.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                if graph[nx][ny] == 'D':
                    return count, True
                
                if graph[nx][ny] == '*' or graph[nx][ny] == 'X':
                    continue
                if visited[nx][ny] == True:
                    continue
                visited[nx][ny] = True
                graph[nx][ny] = 'S'
                q.append((nx, ny, count + 1))

        if len(q) == 0:
            break

    return count, False

count, status = bfs(x, y)
if status == True:
    print(count)
else:
    print('KAKTUS')