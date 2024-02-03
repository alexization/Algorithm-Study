import sys
sys.setrecursionlimit(10**7)

input = sys.stdin.readline

def dfs(x, y, color):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        if picture[nx][ny] == color and visited[nx][ny] == 0:
            visited[nx][ny] = 1
            dfs(nx, ny, color)

n = int(input())
picture = []
visited = [[0 for _ in range(n)] for _ in range(n)]

for _ in range(n):
    picture.append(list(input().strip()))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

count = 0
a_count = 0
for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            count += 1
            dfs(i, j, picture[i][j])

visited = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if picture[i][j] == 'R':
            picture[i][j] = 'G'

for i in range(n):
    for j in range(n):
        if visited[i][j] == 0:
            a_count+=1
            dfs(i, j, picture[i][j])

print(count, a_count)