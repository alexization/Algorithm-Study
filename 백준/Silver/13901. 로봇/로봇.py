import sys
input = sys.stdin.readline

r, c = map(int, input().split())
k = int(input())
k_list = []
for _ in range(k):
    br, bc = map(int, input().split())
    k_list.append((br, bc))

sr, sc = map(int, input().split())
dir_list = list(map(int, input().split()))

graph = [[0] * c for _ in range(r)]
for br, bc in k_list:
    graph[br][bc] = 'X'

dx = []
dy = []

for dir in dir_list:
    if dir == 1:
        dx.append(-1)
        dy.append(0)
    elif dir == 2:
        dx.append(1)
        dy.append(0)
    elif dir == 3:
        dx.append(0)
        dy.append(-1)
    else:
        dx.append(0)
        dy.append(1)

visited = [[False] * c for _ in range(r)]
direction = 0
count = 0
while True:
    if count == 4:
        break

    visited[sr][sc] = True
    nx = sr + dx[direction]
    ny = sc + dy[direction]
    
    if nx < 0 or ny < 0 or nx >= r or ny >= c or visited[nx][ny] == True or graph[nx][ny] == 'X':
        direction = (direction + 1) % 4
        count += 1
        continue
    
    visited[nx][ny] = True
    graph[nx][ny] = graph[sr][sc] + 1
    sr, sc = nx, ny
    count = 0

print(sr, sc)