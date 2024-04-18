import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

result = 0
# dir -> 0 : 가로, 1 : 세로 , 2 : 대각선 
def dfs(x, y, dir):
    global result
    
    if x == n-1 and y == n-1:
        result += 1
        return
    
    if dir == 0 or dir == 2:
        if y + 1 < n:
            if graph[x][y+1] == 0:
                dfs(x, y+1, 0)

    if dir == 1 or dir == 2:
        if x + 1 < n:
            if graph[x+1][y] == 0:
                dfs(x+1, y, 1)
    
    if x + 1 < n and y + 1 < n:
        if graph[x+1][y+1] == 0 and graph[x][y+1] == 0 and graph[x+1][y] == 0:
            dfs(x+1, y+1, 2)


dfs(0, 1, 0)
print(result)