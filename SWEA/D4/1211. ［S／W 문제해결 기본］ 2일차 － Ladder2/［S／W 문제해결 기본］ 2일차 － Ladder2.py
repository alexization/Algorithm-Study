from collections import deque
dx = [0, 0, 1]
dy = [-1, 1, 0]

def bfs(x, y):
    q = deque()
    q.append((x, y, 0))
    visited[x][y] = True

    while q:
        x, y, count = q.popleft()
        if x == 99:
            return count
        
        for i in range(3):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 100 and 0 <= ny < 100:
                if visited[nx][ny] == False:
                    if graph[nx][ny] == 1:
                        visited[nx][ny] = True
                        q.append((nx, ny, count+1))
                        break

T = 10
for test_case in range(1, T+1):
    n = int(input())
    graph = []
    for _ in range(100):
        graph.append(list(map(int, input().split())))
    
    minValue = int(1e9)
    result = -1
    for i in range(100):
        if graph[0][i] == 1:
            visited = [[False] * 100 for _ in range(100)]
            value = bfs(0, i)
            if value < minValue:
                result = i
                minValue = value
        
    print(f"#{test_case} {result}")