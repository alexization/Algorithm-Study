from collections import deque
T = 10

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        if x == fx and y == fy:
            return 1
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 100 and 0 <= ny < 100:
                if visited[nx][ny] == False:
                    if graph[nx][ny] != 1:
                        visited[nx][ny] = True
                        q.append((nx, ny))

    return 0

for test_case in range(1, T+1):
    n = int(input())
    graph = []
    for _ in range(100):
        graph.append(list(map(int, input())))
    
    sx, sy, fx, fy = -1, -1, -1, -1
    for i in range(100):
        for j in range(100):
            if graph[i][j] == 2:
                sx, sy = i, j
            elif graph[i][j] == 3:
                fx, fy = i, j

    visited = [[False] * 100 for _ in range(100)]

    result = bfs(sx, sy)
    print(f"#{test_case} {result}")