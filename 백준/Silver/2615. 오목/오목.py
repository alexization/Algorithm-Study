import sys
from collections import deque
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(19)]

# 우, 아래, 아랫대각, 좌윗대각
dx = [0, 1, 1, -1]
dy = [1, 0, 1, 1]

# 좌, 위, 윗대각, 좌아랫대각
cx = [0, -1, -1, 1]
cy = [-1, 0, -1, -1]

def check(x, y, color, dir):
    nx = x + cx[dir]
    ny = y + cy[dir]
    if nx < 0 or ny < 0 or nx >= 19 or ny >= 19:
        return False
    if board[nx][ny] == color:
        return True
    return False

def checkCount(x, y, color, dir):
    if check(x, y, color, dir):
        count = 0
        return count
    q = deque()
    count = 1
    q.append((x, y, count))

    while q:
        x, y, count = q.popleft()
        nx = x + dx[dir]
        ny = y + dy[dir]
        if nx < 0 or ny < 0 or nx >= 19 or ny >= 19:
            return count
        if board[nx][ny] != color:
            return count
        q.append((nx, ny, count+1))
    return count

result = []
for i in range(19):
    for j in range(19):
        status = False
        if board[i][j] == 1:
            for k in range(4):
                if checkCount(i, j, 1, k) == 5:
                    status = True
                    result.append((1, i+1, j+1))
                    break
        elif board[i][j] == 2:
            for k in range(4):
                if checkCount(i, j, 2, k) == 5:
                    status = True
                    result.append((2, i+1, j+1))
                    break
        if status:
            break
    if status:
        break

if len(result) == 0:
    print(0)
else:
    print(result[0][0])
    print(result[0][1], result[0][2])