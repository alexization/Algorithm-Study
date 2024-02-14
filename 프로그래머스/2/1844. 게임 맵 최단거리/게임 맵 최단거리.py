from collections import deque
def solution(maps):
    answer = 0
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    n = len(maps)
    m = len(maps[0])

    q = deque()
    q.append((0, 0))
    while q:
        idx = q.popleft()
        x, y = idx[0], idx[1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if maps[nx][ny] == 0 or maps[nx][ny] != 1:
                continue
            maps[nx][ny] = maps[x][y] + 1
            q.append((nx, ny))
    
    if maps[n-1][m-1] == 1:
        answer = -1
    else:
        answer = maps[n-1][m-1]
    return answer