from collections import deque
import sys
input = sys.stdin.readline

t = int(input())

dx = [-2, -2, 2, 2, 1, -1, 1, -1]
dy = [1, -1, 1, -1, 2, 2, -2, -2]

def bfs(x, y):
    q = deque()
    q.append((x, y, 0))
    visited[x][y] = True
    while q:
        x, y, count = q.popleft()
        if x == mx and y == my:
            return count

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if visited[nx][ny] == True:
                continue
            visited[nx][ny] = True
            q.append((nx, ny, count+1))

for _ in range(t):
    n = int(input())
    graph = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    x, y = map(int, input().split())
    mx, my = map(int, input().split())

    print(bfs(x, y))