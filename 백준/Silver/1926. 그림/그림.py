from collections import deque
import sys

input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    board[x][y] = 2
    count = 1
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
            if board[nx][ny] == 0  or board[nx][ny] == 2:
                continue
            board[nx][ny] = 2
            count += 1
            q.append((nx, ny))
    return count

maxValue = 0
valCount = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            result = bfs(i, j)
            valCount += 1
            maxValue = max(maxValue, result)

print(valCount)
print(maxValue)