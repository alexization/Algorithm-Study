import sys
import copy
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

cctv_pos = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0 or graph[i][j] == 6:
            continue
        cctv_pos.append((graph[i][j], i, j))

direction = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]],
    [[0, 1, 2, 3]]
]

# 0: 북, 1: 동, 2: 남, 3: 서
dx = [-1, 0, 1, 0] 
dy = [0, 1, 0, -1]

def fill(board, move, x, y):
    for i in move:
        nx = x
        ny = y
        while True:
            nx += dx[i]
            ny += dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                break
            if board[nx][ny] == 6:
                break
            if board[nx][ny] == 0:
                board[nx][ny] = 7
            

def dfs(depth, arr):
    global min_value
    if depth == len(cctv_pos):
        count = 0
        for i in range(n):
            count += arr[i].count(0)
        min_value = min(min_value, count)
        return

    tmp = copy.deepcopy(arr)
    cctv, x, y = cctv_pos[depth]
    for i in direction[cctv]:
        fill(tmp, i, x, y)
        dfs(depth+1, tmp)
        tmp = copy.deepcopy(arr)

min_value = int(1e9)
dfs(0, graph)
print(min_value)