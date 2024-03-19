from collections import deque
import sys
input = sys.stdin.readline

m, n = map(int, input().split())
graph = []
for _ in range(m):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def melt(x, y, graph, visited):
    q = deque()
    q.append((x, y))
    graph[x][y] = 0
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if visited[nx][ny] == True:
                continue
            if graph[nx][ny] == -1:
                graph[x][y] = 0
            if graph[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny))

def change(graph):
    for i in range(m):
        for j in range(n):
            if graph[i][j] == -1:
                graph[i][j] = 0

def around_check():
    q = deque()
    visited = [[False] * n for _ in range(m)]
    q.append((0, 0))
    graph[0][0] = -1
    visited[0][0] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue
            if visited[nx][ny] == True:
                continue
            if graph[nx][ny] == 1:
                continue
            visited[nx][ny] = True
            graph[nx][ny] = -1
            q.append((nx, ny))

def count_cheese(graph):
    count = 0
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                count += 1
    
    return count

def available(graph):
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1:
                return True
    
    return False


count = 0
final_cheese = 0
while True:

    status = available(graph)
    if status == False:
        break
    final_cheese = count_cheese(graph)
    around_check()

    visited = [[False] * n for _ in range(m)]
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1 and visited[i][j] == False:
                melt(i, j, graph, visited)

    change(graph)
    count += 1

print(count)
print(final_cheese)