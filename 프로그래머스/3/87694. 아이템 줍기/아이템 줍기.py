from collections import deque
def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    graph = [[-1 for _ in range(102)] for _ in range(102)]

    for r in rectangle:
        x1, y1, x2, y2 = r[0]*2, r[1]*2, r[2]*2, r[3]*2
        for i in range(y1, y2+1):
            for j in range(x1, x2+1):
                if i == y1 or i == y2 or j == x1 or j == x2:
                    if graph[i][j] == -2:
                        graph[i][j] = -2
                    else:
                        graph[i][j] = 0
                else:
                    graph[i][j] = -2

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    q = deque()
    q.append((characterX*2, characterY*2))
    while q:
        pos = q.popleft()
        x, y = pos[0], pos[1]
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx > 102 or ny > 102:
                continue
            if graph[ny][nx] != 0:
                continue
            graph[ny][nx] = graph[y][x] + 1
            q.append((nx, ny))

    answer = (graph[itemY*2][itemX*2])//2
    return answer