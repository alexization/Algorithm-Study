import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(input().strip()) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if board[i][j] == 'R':
            rx, ry = i, j
        if board[i][j] == 'B':
            bx, by = i, j

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

visited = []
q = deque()
q.append([rx, ry, bx, by, 1])
visited.append([rx, ry, bx, by])

def bfs():
    while q:
        rx, ry, bx, by, count = q.popleft()

        if count > 10:
            break
        for i in range(4):
            nrx, nry, rcnt = slide(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = slide(bx, by, dx[i], dy[i])

            if board[nbx][nby] == 'O':
                continue

            if board[nrx][nry] == 'O':
                return count
            
            if nrx == nbx and nry == nby:
                if rcnt > bcnt:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]
            
            if [nrx, nry, nbx, nby] not in visited:
                visited.append([nrx, nry, nbx, nby])
                q.append([nrx, nry, nbx, nby, count+1])
    
    return -1

def slide(x, y, i, j):
    count = 0
    while True:
        if board[x+i][y+j] == '#':
            break
        if board[x][y] == 'O':
            break
        x += i
        y += j
        count += 1
    return x, y, count

print(bfs())