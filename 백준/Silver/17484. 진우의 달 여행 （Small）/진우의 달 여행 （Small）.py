import sys
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

dy = [-1, 0, 1]
result = []

def dfs(x, y, value, dir):
    global result
    if x == n-1:
        result.append(value)
        return
    
    if dir == 0:
        for i in (1, 2):
            nx = x + 1
            ny = y + dy[i]
            if ny < 0 or ny == m:
                continue
            dfs(nx, ny, value + graph[nx][ny], i)
        
    elif dir == 1:
        for i in (0, 2):
            nx = x + 1
            ny = y + dy[i]
            if ny < 0 or ny == m:
                continue
            dfs(nx, ny, value + graph[nx][ny], i)

    else:
        for i in (0, 1):
            nx = x + 1
            ny = y + dy[i]
            if ny < 0 or ny == m:
                continue
            dfs(nx, ny, value + graph[nx][ny], i)

minValue = int(1e9)
for i in range(m):
    for j in range(3):
        dfs(0, i, graph[0][i], j)

result.sort()
print(result[0])