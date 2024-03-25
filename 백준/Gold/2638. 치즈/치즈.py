from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
cheese = []
for _ in range(n):
    cheese.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def check():
    q = deque()
    visited = [[False] * m for _ in range(n)]
    visited[0][0] = True
    q.append((0, 0))

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if visited[nx][ny] == True:
                continue
            if cheese[nx][ny] >= 1:
                cheese[nx][ny] += 1
                continue
            visited[nx][ny] = True
            q.append((nx, ny))

def melt():
    status = False
    for i in range(n):
        for j in range(m):
            if cheese[i][j] >= 3:
                cheese[i][j] = 0
                status = True
            elif cheese[i][j] >= 2:
                cheese[i][j] = 1
                status = True
    
    return status

time = 0
while True:
    check()
    status = melt()
    if status == False:
        break
    time += 1

print(time)