import sys

input = sys.stdin.readline

n, m = map(int, input().split())
x, y, d = map(int, input().split())
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

data = []
for i in range(n):
    data.append(list(map(int, input().split())))

count = 0
while True:
    if data[x][y] == 0:
        count += 1
        data[x][y] = 2
    
    all_clean = True
    for i in range(d+3, d-1, -1):
        nx = dx[i%4] + x
        ny = dy[i%4] + y
        if data[nx][ny] == 0:
            d = i%4
            x = nx
            y = ny
            all_clean = False
            break

    if all_clean == True:
        nx = dx[d-2] + x
        ny = dy[d-2] + y
        if data[nx][ny] == 1:
            break
        elif data[nx][ny] == 2:
            x = nx
            y = ny

print(count)