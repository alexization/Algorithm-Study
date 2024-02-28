import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(input().strip()))

fire_pos = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'F':
            fire_pos.append((i, j))
        elif graph[i][j] == 'J':
            x, y = i, j

fire_visited = [[False] * m for _ in range(n)]        
visited = [[False] * m for _ in range(n)] 

dx = [-1, 0 ,1, 0]
dy = [0, 1, 0, -1]       
def bfs(x, y):
    q = deque()
    q.append((x, y, 1))
    visited[x][y] = True
    
    while True:
        status = True
        for _ in range(len(q)):
            x, y, count = q.popleft()

            if graph[x][y] == 'F':
                continue
            
            if x == 0 or y == 0 or x == n-1 or y == m-1:
                status = False
                break
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                if graph[nx][ny] == '#' or graph[nx][ny] == 'F':
                    continue
                if visited[nx][ny] == True:
                    continue
                visited[nx][ny] = True
                graph[nx][ny] = 'J'
                q.append((nx, ny, count + 1))
            
        if len(q) == 0:
            break
        
        if status == False:
            break
          
        for _ in range(len(fire_pos)):
            fx, fy = fire_pos.popleft()
            fire_visited[fx][fy] = True
            for i in range(4):
                nx = fx + dx[i]
                ny = fy + dy[i]
                if nx < 0 or ny < 0 or nx >= n or ny >= m:
                    continue
                if graph[nx][ny] == '#':
                    continue
                if fire_visited[nx][ny] == True:
                    continue
                
                fire_visited[nx][ny] = True
                graph[nx][ny] = 'F'
                fire_pos.append((nx, ny))
                
    return count, status

count, status = bfs(x, y)

if status == True:
    print('IMPOSSIBLE')
else:
    print(count)