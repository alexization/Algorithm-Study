n, m = map(int, input().split())

data = []
graph = [[0] * m for _ in range(n)]

for _ in range(n):
    data.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = 0

def virus(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= 0 and ny >= 0 and nx < n and ny < m:
            if graph[nx][ny] == 0:
                graph[nx][ny] = 2
                virus(nx, ny)

def get_score():
    count = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                count += 1
    return count

def dfs(count):
    global result
    if count == 3:
        for i in range(n):
            for j in range(m):
                graph[i][j] = data[i][j]
    
        for i in range(n):
            for j in range(m):
                if graph[i][j] == 2:
                    virus(i, j)
        
        result = max(result, get_score())
        return

    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                count += 1
                dfs(count)
                data[i][j] = 0
                count -= 1

dfs(0)
print(result)